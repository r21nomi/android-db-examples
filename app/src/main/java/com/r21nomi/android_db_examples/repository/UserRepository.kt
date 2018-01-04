package com.r21nomi.android_db_examples.repository

import com.r21nomi.data.user.entity.User
import com.r21nomi.data.user.local.UserDbClient
import com.r21nomi.data.user.remote.UserApi
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by r21nomi on 2018/01/04.
 */
@Singleton
class UserRepository @Inject constructor(
        private val userDbClient: UserDbClient,
        private val userApi: UserApi
) {

    private val userProcessor = BehaviorProcessor.create<User>()

    fun fetchUser(accountName: String): Completable {
        return userApi.getUser(accountName)
                .subscribeOn(Schedulers.io())
                .flatMapCompletable {
                    Completable.fromCallable {
                        userDbClient.upsert(it)
                        userProcessor.onNext(it)

                        val user: User? = userDbClient.get(it.id)
                        Timber.d("found user : ${user?.accountName ?: "no..."}")

                        userDbClient.getAll().forEach {
                            Timber.d("id: ${it.id}, accountName: ${it.accountName}, name: ${it.name}")
                        }
                    }
                }
    }

    fun observeUser(): Flowable<User> = userProcessor.onBackpressureLatest()
}
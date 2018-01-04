package com.r21nomi.android_db_examples.domain.usecase

import com.r21nomi.android_db_examples.repository.UserRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/04.
 */
class FetchUser @Inject constructor(private val userRepository: UserRepository) {

    fun execute(accountName: String): Completable = userRepository.fetchUser(accountName)
}
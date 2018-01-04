package com.r21nomi.android_db_examples.domain.usecase

import com.r21nomi.android_db_examples.repository.UserRepository
import com.r21nomi.data.user.entity.User
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/04.
 */
class ObserveUser @Inject constructor(private val userRepository: UserRepository) {

    fun execute(): Flowable<User> = userRepository.observeUser()
}
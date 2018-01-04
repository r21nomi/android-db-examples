package com.r21nomi.android_db_examples.domain.usecase

import com.r21nomi.android_db_examples.repository.ReposRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/04.
 */
class FetchRepos @Inject constructor(private val reposRepository: ReposRepository) {

    fun execute(user: String): Completable = reposRepository.fetchRepos(user)
}
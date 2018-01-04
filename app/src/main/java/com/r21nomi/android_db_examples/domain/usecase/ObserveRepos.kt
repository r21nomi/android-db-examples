package com.r21nomi.android_db_examples.domain.usecase

import com.r21nomi.android_db_examples.repository.ReposRepository
import com.r21nomi.data.repos.entity.Repo
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/04.
 */
class ObserveRepos @Inject constructor(private val reposRepository: ReposRepository) {

    fun execute(): Flowable<List<Repo>> = reposRepository.observeRepos()
}
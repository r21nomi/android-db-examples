package com.r21nomi.data.repos.remote

import com.r21nomi.data.repos.entity.Repo
import io.reactivex.Single

/**
 * Created by r21nomi on 2018/01/04.
 */
interface ReposApi {

    fun getRepos(user: String): Single<List<Repo>>
}
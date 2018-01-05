package com.r21nomi.data.repos.local

import com.r21nomi.data.repos.entity.Repo

/**
 * Created by r21nomi on 2018/01/05.
 */
interface RepoDbClient {

    fun upsert(repo: Repo)

    fun upsert(repos: List<Repo>)

    fun get(id: Long): Repo?
}
package com.r21nomi.data.repos.local

import com.r21nomi.data.repos.entity.OrmaDatabase
import com.r21nomi.data.repos.entity.Repo
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/05.
 */
class RepoSqlClient @Inject constructor(private val orma: OrmaDatabase): RepoDbClient {

    override fun upsert(repo: Repo) {
        orma.relationOfRepo().upsert(repo)
    }

    override fun upsert(repos: List<Repo>) {
        orma.relationOfRepo().upsert(repos)
    }

    override fun get(id: Long): Repo? {
        return orma.selectFromRepo().idEq(id).firstOrNull()
    }
}
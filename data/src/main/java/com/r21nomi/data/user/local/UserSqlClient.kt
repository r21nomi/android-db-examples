package com.r21nomi.data.user.local

import com.r21nomi.data.user.entity.OrmaDatabase
import com.r21nomi.data.user.entity.User
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/04.
 */
class UserSqlClient @Inject constructor(private val orma: OrmaDatabase) : UserDbClient {

    override fun upsert(user: User) {
        orma.relationOfUser().upsert(user)
    }

    override fun get(id: Long): User? {
        return orma.selectFromUser().idEq(id).firstOrNull()
    }

    override fun getAll(): List<User> {
        return orma.selectFromUser().toList()
    }
}
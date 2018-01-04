package com.r21nomi.data.user.local

import com.r21nomi.data.user.entity.User

/**
 * Created by r21nomi on 2018/01/04.
 */
interface UserDbClient {

    fun upsert(user: User)

    fun get(id: Long): User?

    fun getAll(): List<User>
}
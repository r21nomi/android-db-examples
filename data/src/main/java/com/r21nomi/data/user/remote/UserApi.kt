package com.r21nomi.data.user.remote

import com.r21nomi.data.user.entity.User
import io.reactivex.Single

/**
 * Created by r21nomi on 2018/01/04.
 */
interface UserApi {

    fun getUser(accountName: String): Single<User>
}
package com.r21nomi.data.user

import com.r21nomi.data.user.local.UserDbClient
import com.r21nomi.data.user.local.UserSqlClient
import com.r21nomi.data.user.remote.UserApi
import com.r21nomi.data.user.remote.UserApiClient
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by r21nomi on 2018/01/04.
 */
@Module
abstract class UserModule {

    @Binds
    @Singleton
    abstract fun provideUserApi(reposApiClient: UserApiClient): UserApi

    @Binds
    @Singleton
    abstract fun provideUserDbClient(userSqlClient: UserSqlClient): UserDbClient
}
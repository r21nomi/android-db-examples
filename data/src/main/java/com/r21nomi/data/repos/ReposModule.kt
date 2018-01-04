package com.r21nomi.data.repos

import com.r21nomi.data.repos.remote.ReposApi
import com.r21nomi.data.repos.remote.ReposApiClient
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by r21nomi on 2018/01/04.
 */
@Module
abstract class ReposModule {

    @Binds
    @Singleton
    abstract fun provideReposApi(reposApiClient: ReposApiClient): ReposApi
}
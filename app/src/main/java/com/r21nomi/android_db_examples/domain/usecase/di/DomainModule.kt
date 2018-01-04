package com.r21nomi.android_db_examples.domain.usecase.di

import com.r21nomi.android_db_examples.repository.di.RepositoryModule
import dagger.Module

/**
 * Created by r21nomi on 2018/01/04.
 */
@Module(
        includes = arrayOf(
                RepositoryModule::class
        )
)
class DomainModule {
}
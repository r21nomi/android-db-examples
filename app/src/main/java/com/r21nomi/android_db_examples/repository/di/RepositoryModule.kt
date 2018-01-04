package com.r21nomi.android_db_examples.repository.di

import com.r21nomi.data.di.DataModule
import dagger.Module

/**
 * Created by r21nomi on 2018/01/04.
 */
@Module(
        includes = arrayOf(
                DataModule::class
        )
)
class RepositoryModule {
}
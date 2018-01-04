package com.r21nomi.android_db_examples.di

import android.app.Application
import android.content.Context
import com.r21nomi.android_db_examples.App
import dagger.Binds
import dagger.Module

/**
 * Created by r21nomi on 2018/01/04.
 */
@Module(
        subcomponents = arrayOf()
)
abstract class ApplicationModule {

    @Binds
    abstract fun provideApplication(app: App): Application

    @Binds
    abstract fun provideApplicationContext(application: Application): Context
}
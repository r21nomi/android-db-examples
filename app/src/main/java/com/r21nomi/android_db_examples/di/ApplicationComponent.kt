package com.r21nomi.android_db_examples.di

import com.r21nomi.android_db_examples.App
import com.r21nomi.android_db_examples.domain.usecase.di.DomainModule
import com.r21nomi.android_db_examples.ui.main.di.MainModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by r21nomi on 2018/01/04.
 */
@Singleton
@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                ApplicationModule::class,
                DomainModule::class,
                MainModule::class
        )
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
package com.r21nomi.android_db_examples.ui.main.di

import com.r21nomi.android_db_examples.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by r21nomi on 2018/01/04.
 */
@Module
abstract class MainModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}
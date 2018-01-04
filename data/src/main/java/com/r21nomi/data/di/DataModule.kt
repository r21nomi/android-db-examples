package com.r21nomi.data.di

import com.r21nomi.data.repos.ReposModule
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by r21nomi on 2018/01/04.
 */
@Module(
        includes = arrayOf(
                ReposModule::class
        )
)
class DataModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}
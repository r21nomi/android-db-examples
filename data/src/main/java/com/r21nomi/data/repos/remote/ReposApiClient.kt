package com.r21nomi.data.repos.remote

import com.r21nomi.data.repos.entity.Repo
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/04.
 */
class ReposApiClient internal constructor(private val service: Service): ReposApi {

    @Inject
    constructor(retrofit: Retrofit) : this(retrofit.create(Service::class.java))

    override fun getRepos(user: String): Single<List<Repo>> {
        return service.getRepos(user)
    }

    internal interface Service {
        @GET("/users/{user}/repos")
        fun getRepos(@Path("user") user: String): Single<List<Repo>>
    }
}
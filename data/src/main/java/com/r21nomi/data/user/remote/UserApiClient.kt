package com.r21nomi.data.user.remote

import com.r21nomi.data.user.entity.User
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

/**
 * Created by r21nomi on 2018/01/04.
 */
class UserApiClient internal constructor(private val service: Service): UserApi {

    @Inject
    constructor(retrofit: Retrofit) : this(retrofit.create(Service::class.java))

    override fun getUser(accountName: String): Single<User> {
        return service.getRepos(accountName)
    }

    internal interface Service {
        @GET("/users/{user}")
        fun getRepos(@Path("user") accountName: String): Single<User>
    }
}
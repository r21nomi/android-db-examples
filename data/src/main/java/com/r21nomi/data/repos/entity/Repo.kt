package com.r21nomi.data.repos.entity

import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Table
import com.r21nomi.data.user.entity.User
import com.squareup.moshi.Json

/**
 * Created by r21nomi on 2018/01/04.
 */
@Table
data class Repo(
        @PrimaryKey(auto = false)
        var id: Long = 0,

        @Column
        var name: String = "",

        @Json(name = "full_name")
        @Column
        var fullName: String = "",

        @Json(name = "stargazers_count")
        @Column
        var stargazersCount: Int = 0,

        @Column
        var description: String? = null,

        @Json(name = "owner")
        @Column
        var user: User? = null
)
package com.r21nomi.data.user.entity

import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Table
import com.squareup.moshi.Json

/**
 * Created by r21nomi on 2018/01/04.
 */
@Table
data class User(
        @PrimaryKey(auto = false)
        var id: Long = 0,

        @Json(name = "login")
        @Column
        var accountName: String = "",

        @Column
        var name: String = "",

        var bio: String = "",

        var public_repos: Int = 0,

        var followers: Int = 0,

        var following: Int = 0
)
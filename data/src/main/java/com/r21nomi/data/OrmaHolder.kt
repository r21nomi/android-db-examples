package com.r21nomi.data

import android.content.Context
import com.r21nomi.data.user.entity.OrmaDatabase

/**
 * Created by r21nomi on 2018/01/04.
 */
object OrmaHolder {

    lateinit var ORMA: OrmaDatabase

    fun initialize(context: Context) {
        ORMA = OrmaDatabase.builder(context).build()
    }
}
package com.r21nomi.android_db_examples.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.r21nomi.android_db_examples.R
import com.r21nomi.android_db_examples.domain.usecase.FetchRepos
import com.r21nomi.android_db_examples.domain.usecase.FetchUser
import com.r21nomi.android_db_examples.domain.usecase.ObserveRepos
import com.r21nomi.android_db_examples.domain.usecase.ObserveUser
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var fetchUser: FetchUser
    @Inject lateinit var observeUser: ObserveUser
    @Inject lateinit var fetchRepos: FetchRepos
    @Inject lateinit var observeRepos: ObserveRepos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).text = "loading..."

        fetchUser.execute("r21nomi")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("fetchUser: success")
                }, {
                    Timber.e(it)
                })

        fetchRepos.execute("r21nomi")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("fetchRepos: success")
                }, {
                    Timber.e(it)
                })
    }

    override fun onResume() {
        super.onResume()

        observeUser.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Timber.d("accountName: ${it.accountName}")
                }

        observeRepos.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    findViewById<TextView>(R.id.text).text = "repository count: ${it.size}"
                }
    }
}

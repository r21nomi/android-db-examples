package com.r21nomi.android_db_examples.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.r21nomi.android_db_examples.R
import com.r21nomi.android_db_examples.domain.usecase.FetchRepos
import com.r21nomi.android_db_examples.domain.usecase.ObserveRepos
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var fetchRepos: FetchRepos
    @Inject lateinit var observeRepos: ObserveRepos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).text = "loading..."

        fetchRepos.execute("r21nomi")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(this.localClassName, "success")
                }, {
                    Log.e(this.localClassName, it.message, it)
                })
    }

    override fun onResume() {
        super.onResume()

        observeRepos.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    findViewById<TextView>(R.id.text).text = "repository count: ${it.size}"
                }
    }
}

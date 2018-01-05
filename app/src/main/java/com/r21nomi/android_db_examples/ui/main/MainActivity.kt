package com.r21nomi.android_db_examples.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.r21nomi.android_db_examples.R
import com.r21nomi.android_db_examples.databinding.ActivityMainBinding
import com.r21nomi.android_db_examples.domain.usecase.FetchRepos
import com.r21nomi.android_db_examples.domain.usecase.FetchUser
import com.r21nomi.android_db_examples.domain.usecase.ObserveRepos
import com.r21nomi.android_db_examples.domain.usecase.ObserveUser
import com.r21nomi.data.repos.entity.OrmaDatabase
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var fetchUser: FetchUser
    @Inject
    lateinit var observeUser: ObserveUser
    @Inject
    lateinit var fetchRepos: FetchRepos
    @Inject
    lateinit var observeRepos: ObserveRepos

    @Inject
    lateinit var orma: OrmaDatabase

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val adapter: RepoAdapter by lazy {
        RepoAdapter(this, orma.relationOfRepo().orderByIdDesc())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
        }
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
                    Timber.d("repository count: ${it.size}")
                }
    }
}

package com.r21nomi.android_db_examples.ui.main

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.gfx.android.orma.Relation
import com.github.gfx.android.orma.widget.OrmaRecyclerViewAdapter
import com.r21nomi.android_db_examples.R
import com.r21nomi.android_db_examples.databinding.RepoViewholderBinding
import com.r21nomi.data.repos.entity.Repo

/**
 * Created by r21nomi on 2018/01/05.
 */
class RepoAdapter(context: Context, relation: Relation<Repo, *>)
    : OrmaRecyclerViewAdapter<Repo, RepoAdapter.ViewHolder>(context, relation) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<RepoViewholderBinding>(
                LayoutInflater.from(parent.context), R.layout.repo_viewholder, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.run {
            title.text = getItem(position).fullName
            starCount.text = "☆ ${getItem(position).stargazersCount}"
        }
    }

    inner class ViewHolder(val binding: RepoViewholderBinding) : RecyclerView.ViewHolder(binding.root)
}
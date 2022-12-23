package com.example.popularlibraries.ui.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.popularlibraries.databinding.ItemRepoBinding
import com.mirkhusainov.geekbrainscourse.model.GithubRepo

typealias OnRepoClickListener = (item: GithubRepo) -> Unit

class ReposAdapter(
    private val onUserClickListener: OnRepoClickListener
) : RecyclerView.Adapter<GithubRepoViewHolder>() {

    var repos: List<GithubRepo> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        val binding = ItemRepoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GithubRepoViewHolder(binding, onUserClickListener)
    }

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount() = repos.size
}

class GithubRepoViewHolder(
    private val binding: ItemRepoBinding,
    private val onUserClickListener: OnRepoClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: GithubRepo) = with(binding) {
        tvRepoName.text = item.name
        root.setOnClickListener {
            onUserClickListener.invoke(item)
        }
    }
}
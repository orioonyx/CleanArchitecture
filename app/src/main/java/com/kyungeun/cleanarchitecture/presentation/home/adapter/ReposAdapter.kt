package com.kyungeun.cleanarchitecture.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyungeun.cleanarchitecture.databinding.LayoutReposBinding
import com.kyungeun.cleanarchitecture.domain.model.GitRepos

class ReposAdapter : RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    private val gitRepos: ArrayList<GitRepos> = ArrayList()
    private lateinit var context: Context

    class ReposViewHolder(binding: LayoutReposBinding) : RecyclerView.ViewHolder(binding.root) {

        val name = binding.nameTv
        val desc = binding.descTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        context = parent.context
        val viewBinding = LayoutReposBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReposViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        gitRepos[position].also {
            holder.name.text = it.name
            holder.desc.text = it.description
        }
    }

    override fun getItemCount(): Int = gitRepos.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newPraySchedules: List<GitRepos>) {
        gitRepos.run {
            clear()
            addAll(newPraySchedules)
            notifyDataSetChanged()
        }
    }
}
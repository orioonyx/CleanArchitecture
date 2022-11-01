package com.kyungeun.cleanarchitecture.presentation.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyungeun.cleanarchitecture.databinding.LayoutPrayBinding
import com.kyungeun.cleanarchitecture.domain.schedule.model.PraySchedule
import com.kyungeun.cleanarchitecture.util.TimeUtil.getTimeFormated

class PrayAdapter : RecyclerView.Adapter<PrayAdapter.PrayViewHolder>() {

    private val praySchedules: ArrayList<PraySchedule> = ArrayList()
    private lateinit var context: Context

    class PrayViewHolder(binding: LayoutPrayBinding) : RecyclerView.ViewHolder(binding.root) {

        val name = binding.prayNameTv
        val time = binding.prayTimeTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayViewHolder {
        context = parent.context
        val viewBinding = LayoutPrayBinding.inflate(LayoutInflater.from(parent.context))
        return PrayViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: PrayViewHolder, position: Int) {
        praySchedules[position].also {
            holder.name.text = it.name
            holder.time.text = it.time.getTimeFormated()
        }
    }

    override fun getItemCount(): Int = praySchedules.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newPraySchedules: List<PraySchedule>) {
        praySchedules.run {
            clear()
            addAll(newPraySchedules)
            notifyDataSetChanged()
        }
    }
}
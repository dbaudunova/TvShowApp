package com.example.tvshowapp.ui.tv_show.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.tvshowapp.data.remote.model.schedule.ScheduleItem
import com.example.tvshowapp.databinding.ItemScheduleBinding

class ScheduleAdapter : Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    private var scheduleList = arrayListOf<ScheduleItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<ScheduleItem>) {
        scheduleList = list as ArrayList<ScheduleItem>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(
            ItemScheduleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = scheduleList.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(scheduleList[position])
    }

    inner class ScheduleViewHolder(private val binding: ItemScheduleBinding) :
        ViewHolder(binding.root) {
        fun bind(scheduleItem: ScheduleItem) {
            binding.apply {
                tvName.text = scheduleItem.name
                tvType.text = scheduleItem.type
                ivPoster.load(scheduleItem.image?.original) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }
    }
}
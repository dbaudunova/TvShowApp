package com.example.tvshowapp.ui.tv_show.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.tvshowapp.data.remote.model.actors.ActorItem
import com.example.tvshowapp.databinding.ItemTvShowBinding

class ActorAdapter : Adapter<ActorAdapter.ActorViewHolder>() {

    private var actorList = arrayListOf<ActorItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<ActorItem>) {
        actorList = list as ArrayList<ActorItem>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(
            ItemTvShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = actorList.size

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actorList[position])
    }

    inner class ActorViewHolder(private val binding: ItemTvShowBinding) : ViewHolder(binding.root) {
        fun bind(actorItem: ActorItem) {
            with(binding) {
                tvName.text = actorItem.name
                ivPoster.load(actorItem.image?.original) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }
    }
}
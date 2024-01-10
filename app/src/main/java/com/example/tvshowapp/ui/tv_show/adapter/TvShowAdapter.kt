package com.example.tvshowapp.ui.tv_show.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.tvshowapp.data.remote.model.TvShowItem
import com.example.tvshowapp.databinding.ItemTvShowBinding

class TvShowAdapter : Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var tvShowList = ArrayList<TvShowItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<TvShowItem>) {
        tvShowList = list as ArrayList<TvShowItem>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        return TvShowViewHolder(
            ItemTvShowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    inner class TvShowViewHolder(private val binding: ItemTvShowBinding) :
        ViewHolder(binding.root) {
        fun bind(tvShowItem: TvShowItem) {
            binding.apply {
                tvName.text = tvShowItem.name
                ivPoster.load(tvShowItem.image?.original) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }
    }
}
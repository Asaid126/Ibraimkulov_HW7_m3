package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSongBinding
class SongsAdapter(private val list: List<Song>, private val onItemClick: (title: String) -> Unit) :
   RecyclerView.Adapter<SongsAdapter.SongsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        return SongsViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class SongsViewHolder(private val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(music: Song) = with(binding) {
            tvRank.text = music.rank
            tvTitle.text = music.title
            tvAuthor.text = music.author
            tvDuration.text = music.duration

            root.setOnClickListener {
                onItemClick(list[adapterPosition].title)
            }
        }
    }
}
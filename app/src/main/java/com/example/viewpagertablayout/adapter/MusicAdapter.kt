package com.example.viewpagertablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertablayout.Entity.MusicEntity
import com.example.viewpagertablayout.R
import kotlinx.android.synthetic.main.rv_items_music.view.*

class MusicAdapter: RecyclerView.Adapter<MusicAdapter.ViewHolder>() {
    private var items: List<MusicEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_items_music,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setMusicAdapter(musicEntity: List<MusicEntity>){
        items = musicEntity
    }

    class ViewHolder constructor(
        view: View
    ): RecyclerView.ViewHolder(view){
        val penyanyi = view.tv_penyanyi_itemsMusic
        val judul = view.tv_judul_itemsMusic

        fun bind(musicEntity: MusicEntity){
            penyanyi.text = musicEntity.penyanyi
            judul.text = musicEntity.judulLagu
        }
    }

}
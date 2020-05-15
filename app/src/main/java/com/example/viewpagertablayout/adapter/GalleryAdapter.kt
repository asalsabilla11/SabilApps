package com.example.viewpagertablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertablayout.Entity.GalleryEntitiy
import com.example.viewpagertablayout.R
import kotlinx.android.synthetic.main.rv_items_gallery.view.*

class GalleryAdapter:RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    private var items: List<GalleryEntitiy> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_items_gallery,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setGalleryAdapter(galleryEntitiy: List<GalleryEntitiy>){
        items = galleryEntitiy
    }

    class ViewHolder constructor(
        view:View
    ): RecyclerView.ViewHolder(view){
        val image = view.iv_image_rvGallery

        fun bind(galleryEntitiy: GalleryEntitiy){
            image.setImageResource(galleryEntitiy.image)
        }
    }

}
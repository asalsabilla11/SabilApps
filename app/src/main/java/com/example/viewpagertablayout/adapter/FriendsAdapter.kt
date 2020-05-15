package com.example.viewpagertablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertablayout.Entity.FriendsListEntity
import com.example.viewpagertablayout.R
import kotlinx.android.synthetic.main.rv_layout_friends.view.*

class FriendsAdapter: RecyclerView.Adapter<FriendsAdapter.ViewHolder>(){
    private var items :List<FriendsListEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_layout_friends,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    fun setFriendsAdapter(friendsList: List<FriendsListEntity>){
        items = friendsList
    }

    class ViewHolder constructor(
        view: View
    ): RecyclerView.ViewHolder(view){
        val title = view.tv_nama_itemsFriends
        val image = view.iv_image_itemsFriends
        fun bind(friendsList: FriendsListEntity){
            title.text = friendsList.nama
            image.setImageResource(friendsList.image)
        }
    }
}
package com.example.viewpagertablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertablayout.Entity.DailyAcitivtyEntity
import com.example.viewpagertablayout.R
import kotlinx.android.synthetic.main.rv_items_daily.view.*

class DailyAdapter:RecyclerView.Adapter<DailyAdapter.ViewHolder>() {

    private var items :List<DailyAcitivtyEntity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_items_daily,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    fun setDailyAdapter(daily: List<DailyAcitivtyEntity>){
        items = daily
    }

    class ViewHolder constructor(
        view:View
    ): RecyclerView.ViewHolder(view){
        val title = view.tv_title_itemnsDaily
        val waktu = view.tv_waktu_itemsDaily

        fun bind(daily: DailyAcitivtyEntity){
            title.text = daily.title
            waktu.text = daily.waktu
        }
    }
}
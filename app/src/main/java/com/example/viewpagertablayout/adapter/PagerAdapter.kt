package com.example.viewpagertablayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertablayout.model.PagerModel
import com.example.viewpagertablayout.R
import kotlinx.android.synthetic.main.vp_items.view.*

class PagerAdapter:RecyclerView.Adapter<PagerAdapter.ViewHolder>() {
    private var items:List<PagerModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.vp_items,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindContent(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun SetPagerAdapater(pagerModel: List<PagerModel>){
        items = pagerModel
    }

    class ViewHolder constructor(
        view:View
    ): RecyclerView.ViewHolder(view){
        val title = view.title_vp
        val desc = view.desc_vp
        val image = view.image_vp

        fun bindContent(pagerModel: PagerModel){
            title.text = pagerModel.title
            desc.text = pagerModel.desc
            image.setBackgroundResource(pagerModel.image)
        }

    }
}
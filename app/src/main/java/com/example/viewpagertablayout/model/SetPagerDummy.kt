package com.example.viewpagertablayout.model

import com.example.viewpagertablayout.R

class SetPagerDummy {
    companion object{
        fun setDataPager(): ArrayList<PagerModel>{
            val list = ArrayList<PagerModel>()
            list.add(
                PagerModel(
                    "Title1",
                    "Description1",
                    R.drawable.exploreme
                )
            )
            list.add(
                PagerModel(
                    "Title2",
                    "Description2",
                    R.drawable.content
                )
            )
            list.add(
                PagerModel(
                    "Title3",
                    "Description3",
                    R.drawable.list
                )
            )
            return list
        }
    }
}
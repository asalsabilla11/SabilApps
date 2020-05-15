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
                    R.drawable.me
                )
            )
            list.add(
                PagerModel(
                    "Title2",
                    "Description2",
                    R.drawable.fav
                )
            )
            list.add(
                PagerModel(
                    "Title3",
                    "Description3",
                    R.drawable.mimpi
                )
            )
            return list
        }
    }
}
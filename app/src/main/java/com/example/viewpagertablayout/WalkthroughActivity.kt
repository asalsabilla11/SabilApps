package com.example.viewpagertablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagertablayout.adapter.PagerAdapter
import com.example.viewpagertablayout.model.SetPagerDummy
import kotlinx.android.synthetic.main.activity_walkthrough.*

class WalkthroughActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        setData()

        viewPager2_main.adapter = pagerAdapter
        viewPager2_main.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        cirleIndicator_main.setViewPager(viewPager2_main)
    }

    fun setData(){
        pagerAdapter = PagerAdapter()
        val data = SetPagerDummy.setDataPager()
        pagerAdapter.SetPagerAdapater(data)
    }
}

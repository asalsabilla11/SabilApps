package com.example.viewpagertablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.viewpagertablayout.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

//Nama : Annisa Salsabilla
//Nim : 10117196
//tgl pembuatan dibuat dari tanggal 8 mei 2020

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu: Menu = bottom_nav.menu
        menuSelected(menu.getItem(0))
        bottom_nav.setOnNavigationItemSelectedListener {
            item: MenuItem -> menuSelected(item)
            false
        }

    }

    private fun menuSelected(items: MenuItem){
        items.isChecked = true
        when(items.itemId){
            R.id.home_menu -> fragmentSelected(HomeFragment.getInstance())
            R.id.daily_menu -> fragmentSelected(DailyFragment.getInstance())
            R.id.gallery_menu -> fragmentSelected(GalleryFragment.getInstance())
            R.id.music_menu -> fragmentSelected(MusicFragment.getInstance())
            R.id.profile_menu -> fragmentSelected(ProfileFragment.getInstance())
        }
    }

    private fun fragmentSelected(fragment: Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout_home,fragment)
        transaction.commit()
    }

}

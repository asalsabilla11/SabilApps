package com.example.viewpagertablayout.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.viewpagertablayout.DatabaseMe
import com.example.viewpagertablayout.Entity.GalleryEntitiy

import com.example.viewpagertablayout.R
import com.example.viewpagertablayout.adapter.GalleryAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_gallery.*

/**
 * A simple [Fragment] subclass.
 */
class GalleryFragment : Fragment() {

    companion object{
        fun getInstance(): GalleryFragment = GalleryFragment()
    }

    private val disposable = CompositeDisposable()
    private lateinit var galleryAdapter: GalleryAdapter
    private var db: DatabaseMe? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        db = DatabaseMe.getInstance(context)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataGallery()
        getDataGallery()
    }

    fun setDataGallery(){
        val data = GalleryEntitiy.setDataGallery()
        disposable.add(Observable.fromCallable { db?.galleryDao()?.insertDataDaily(data) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }
    fun getDataGallery(){
        disposable.add(Observable.fromCallable { db?.galleryDao()?.getDataDaily()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                rv_gallery_gallery.apply {
                    layoutManager = GridLayoutManager(context,2)
                    galleryAdapter = GalleryAdapter()
                    galleryAdapter.setGalleryAdapter(it!!)
                    this.adapter = galleryAdapter
                }
            })
    }

}

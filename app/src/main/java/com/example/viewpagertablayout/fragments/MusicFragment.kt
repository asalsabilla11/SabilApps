package com.example.viewpagertablayout.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagertablayout.DatabaseMe
import com.example.viewpagertablayout.Entity.MusicEntity

import com.example.viewpagertablayout.R
import com.example.viewpagertablayout.adapter.MusicAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_music.*

/**
 * A simple [Fragment] subclass.
 */
class MusicFragment : Fragment() {

    private var dp = CompositeDisposable()
    private var db: DatabaseMe? = null
    private lateinit var musicAdapter: MusicAdapter

    companion object{
        fun getInstance(): MusicFragment = MusicFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        db = DatabaseMe.getInstance(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        getData()
    }

    fun setData() {
        val dataDaily = MusicEntity.setDataMusic()
        dp.add(Observable.fromCallable { db?.musicDao()?.insertDataMusic(dataDaily) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    fun getData() {
        dp.add(Observable.fromCallable { db?.musicDao()?.getDataMusic() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe() {
                rv_musicFav_music.apply {
                    layoutManager = LinearLayoutManager(context)
                    musicAdapter = MusicAdapter()
                    musicAdapter.setMusicAdapter(it!!)
                    this.adapter = musicAdapter
                }
            })
    }
}

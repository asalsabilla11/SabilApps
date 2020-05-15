package com.example.viewpagertablayout.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagertablayout.DatabaseAku
import com.example.viewpagertablayout.Entity.DailyAcitivtyEntity
import com.example.viewpagertablayout.Entity.FriendsListEntity

import com.example.viewpagertablayout.R
import com.example.viewpagertablayout.adapter.DailyAdapter
import com.example.viewpagertablayout.adapter.FriendsAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_daily.*

/**
 * A simple [Fragment] subclass.
 */
class DailyFragment : Fragment() {

    private var dp = CompositeDisposable()
    private var db: DatabaseAku? = null
    private lateinit var dailyAdapter: DailyAdapter
    private lateinit var friendsAdapter: FriendsAdapter

    companion object{
        fun getInstance(): DailyFragment = DailyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        db = DatabaseAku.getInstance(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        getData()
    }

    fun setData(){
        val dataDaily = DailyAcitivtyEntity.setDataDaily()
        dp.add(Observable.fromCallable { db?.dailyDao()?.insertDataDaily(dataDaily)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())

        val dataFriends = FriendsListEntity.setFriendsData()
        dp.add(Observable.fromCallable { db?.friendsListDao()?.setFriendsList(dataFriends)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }
    fun getData(){
        dp.add(Observable.fromCallable { db?.dailyDao()?.getDataDaily()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                rv_daily_daily.apply {
                    layoutManager = LinearLayoutManager(context)
                    dailyAdapter = DailyAdapter()
                    dailyAdapter.setDailyAdapter(it!!)
                    this.adapter = dailyAdapter
                }
            })

        dp.add(Observable.fromCallable { db?.friendsListDao()?.getFriendsList()}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                rv_friends_daily.apply {
                    layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                    friendsAdapter = FriendsAdapter()
                    friendsAdapter.setFriendsAdapter(it!!)
                    this.adapter = friendsAdapter
                }
            })
    }

}

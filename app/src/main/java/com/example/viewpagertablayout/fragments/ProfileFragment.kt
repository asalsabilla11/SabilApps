package com.example.viewpagertablayout.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagertablayout.DatabaseMe
import com.example.viewpagertablayout.Entity.ProfileEntity

import com.example.viewpagertablayout.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    companion object{
        fun getInstance(): ProfileFragment = ProfileFragment()
    }

    private var dp = CompositeDisposable()
    private var db: DatabaseMe? = null
    private var items :List<ProfileEntity> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
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

    fun setData(){
        val data = ProfileEntity.setDataProfile()
        dp.add(Observable.fromCallable { db?.profileDao()?.insertDataProfile(data) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }
    fun getData(){
        dp.add(Observable.fromCallable { db?.profileDao()?.getDataProfile() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(){
                it!!.forEach {
                    iv_image_profile.setImageResource(it.image)
                    tv_nama_profile.text = it.nama
                    tv_desc_profile.text = it.desc
                    tv_email_profile.text = it.email
                    tv_sosmed_profile.text = it.instagram
                    tv_notel_profile.text = it.contact
                }

            })
    }

}

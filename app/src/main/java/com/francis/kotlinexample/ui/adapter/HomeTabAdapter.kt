package com.francis.kotlinexample.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Francis on 2017-8-24.
 */
class HomeTabAdapter(fm: FragmentManager?,private val fragmentList : List<Fragment>,
                     private val titleList: List<String>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

}
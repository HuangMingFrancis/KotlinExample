package com.francis.kotlinexample.ui.activity

import android.graphics.Typeface
import android.view.View
import com.francis.kotlinexample.R
import com.francis.kotlinexample.mvp.contract.HomeContract
import com.francis.kotlinexample.mvp.presenter.HomePresenter
import com.francis.kotlinexample.mvp.BaseMvpActivity
import com.francis.kotlinexample.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by Francis on 2017-8-22.
 */
class HomeActivity(override var mPresenter: HomeContract.Presenter = HomePresenter())
    : BaseMvpActivity<HomeContract.View, HomeContract.Presenter>(), HomeContract.View, View.OnClickListener {

    var homeFragment : HomeFragment ?= null
    var findFragment : HomeFragment ?= null
    var mineFragment : HomeFragment ?= null
    var hotFragemnt : HomeFragment ?= null

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }
    override fun initData() {
        initToolbar()
        initFragment()
    }

    private fun initFragment() {
        homeFragment = HomeFragment()
        findFragment = HomeFragment()
        mineFragment = HomeFragment()
        hotFragemnt = HomeFragment()
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.add(R.id.fl_content, homeFragment)
        fragmentTrans.add(R.id.fl_content, findFragment)
        fragmentTrans.add(R.id.fl_content, mineFragment)
        fragmentTrans.add(R.id.fl_content, hotFragemnt)
        fragmentTrans.commit()

        supportFragmentManager.beginTransaction().show(homeFragment)
                .hide(findFragment)
                .hide(mineFragment)
                .hide(hotFragemnt)
                .commit()
    }

    private fun initToolbar() {
        var today = mPresenter.getToday()
        tv_bar_title.text = today
        tv_bar_title.typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")

    }

    override fun initListener() {
        rb_home.isChecked = true
        rb_home.setTextColor(resources.getColor(R.color.black))
        rb_home.setOnClickListener(this)
        rb_find.setOnClickListener(this)
        rb_hot.setOnClickListener(this)
        rb_mine.setOnClickListener(this)

        iv_search.setOnClickListener {

        }
    }

    override fun onClick(v: View?) {
        clearState()
        when (v?.id) {
            R.id.rb_find -> {
                rb_find.isChecked = true
                rb_find.setTextColor(resources.getColor(R.color.black))
                supportFragmentManager.beginTransaction().show(findFragment)
                        .hide(homeFragment)
                        .hide(mineFragment)
                        .hide(hotFragemnt)
                        .commit()
                tv_bar_title.text = "Discover"
                tv_bar_title.visibility = View.VISIBLE
                iv_search.setImageResource(R.drawable.icon_search)
            }
            R.id.rb_home -> {
                rb_home.isChecked = true
                rb_home.setTextColor(resources.getColor(R.color.black))
                supportFragmentManager.beginTransaction().show(homeFragment)
                        .hide(findFragment)
                        .hide(mineFragment)
                        .hide(hotFragemnt)
                        .commit()
                tv_bar_title.text = mPresenter.getToday()
                tv_bar_title.visibility = View.VISIBLE
                iv_search.setImageResource(R.drawable.icon_search)
            }
            R.id.rb_hot -> {
                rb_hot.isChecked = true
                rb_hot.setTextColor(resources.getColor(R.color.black))
                supportFragmentManager.beginTransaction().show(hotFragemnt)
                        .hide(findFragment)
                        .hide(mineFragment)
                        .hide(homeFragment)
                        .commit()
                tv_bar_title.text = "Ranking"
                tv_bar_title.visibility = View.VISIBLE
                iv_search.setImageResource(R.drawable.icon_search)
            }
            R.id.rb_mine -> {
                rb_mine.isChecked = true
                rb_mine.setTextColor(resources.getColor(R.color.black))
                supportFragmentManager.beginTransaction().show(mineFragment)
                        .hide(findFragment)
                        .hide(homeFragment)
                        .hide(hotFragemnt)
                        .commit()
                tv_bar_title.visibility = View.INVISIBLE
                iv_search.setImageResource(R.drawable.icon_setting)
            }
        }
    }

    private fun clearState() {
        rg_root.clearCheck()
        rb_home.setTextColor(resources.getColor(R.color.gray))
        rb_mine.setTextColor(resources.getColor(R.color.gray))
        rb_hot.setTextColor(resources.getColor(R.color.gray))
        rb_find.setTextColor(resources.getColor(R.color.gray))
    }
}
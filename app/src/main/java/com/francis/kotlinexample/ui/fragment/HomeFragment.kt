package com.francis.kotlinexample.ui.fragment

import com.francis.kotlinexample.R
import com.francis.kotlinexample.flow.home.HomePageContract
import com.francis.kotlinexample.flow.home.HomePagePresenter
import com.francis.kotlinexample.mvp.BaseMvpFragment

/**
 * Created by Francis on 2017-8-24.
 */
class HomeFragment(override var mPresenter: HomePageContract.Presenter = HomePagePresenter()) :
        BaseMvpFragment<HomePageContract.View, HomePageContract.Presenter>(), HomePageContract.View{
    override fun getLayoutResources(): Int {
        return R.layout.fragment_home_page
    }

    override fun initView() {

    }

}
package com.francis.kotlinexample.flow.home

import android.os.Bundle
import com.francis.kotlinexample.mvp.BaseMvpActivity

/**
 * Created by Francis on 2017-8-22.
 */
class HomeActivity(override var mPresenter: HomeContract.Presenter = HomePresenter())
    : BaseMvpActivity< HomeContract.View, HomeContract.Presenter>(), HomeContract.View{
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }
    override fun initData() {
    }

    override fun initListener() {
    }
}
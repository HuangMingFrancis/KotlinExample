package com.francis.kotlinexample.mvp.contract

import com.francis.kotlinexample.api.model.HomeBean
import com.francis.kotlinexample.mvp.BaseMvpPresenter
import com.francis.kotlinexample.mvp.BaseMvpView

/**
 * Created by Francis on 2017-8-30.
 */
object HomePageContract {
    interface View : BaseMvpView {
        fun setData(homeBean: HomeBean)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun getHomeData()
        fun getHomeMoreData(date: String, num: String = "2")
    }
}
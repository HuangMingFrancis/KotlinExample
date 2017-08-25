package com.francis.kotlinexample.mvp.contract

import com.francis.kotlinexample.mvp.BaseMvpPresenter
import com.francis.kotlinexample.mvp.BaseMvpView

/**
 * Created by Francis on 2017-8-22.
 */
object HomeContract {
    interface View : BaseMvpView {

    }

    interface Presenter : BaseMvpPresenter<View> {
        fun getToday(): String
    }
}
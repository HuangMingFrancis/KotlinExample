package com.francis.kotlinexample.flow.home

import com.francis.kotlinexample.mvp.BaseMvpPresenter
import com.francis.kotlinexample.mvp.BaseMvpView

/**
 * Created by Francis on 2017-8-22.
 */
object HomePageContract {
    interface View : BaseMvpView{

    }

    interface Presenter : BaseMvpPresenter<View>{
    }
}
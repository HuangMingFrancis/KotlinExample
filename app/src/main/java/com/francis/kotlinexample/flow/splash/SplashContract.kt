package com.francis.kotlinexample.flow.splash

import com.francis.kotlinexample.mvp.BaseMvpPresenter
import com.francis.kotlinexample.mvp.BaseMvpView

/**
 * Created by Francis on 2017-5-31.
 */
interface SplashContract {
    interface View : BaseMvpView{
    }

    interface Presenter : BaseMvpPresenter<View>{
        fun getServerAppVersion()
    }

}
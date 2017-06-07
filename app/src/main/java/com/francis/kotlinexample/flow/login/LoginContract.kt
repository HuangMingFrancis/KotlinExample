package com.francis.kotlinexample.flow.login

import com.francis.kotlinexample.mvp.BaseMvpPresenter
import com.francis.kotlinexample.mvp.BaseMvpView

/**
 * Created by Francis on 2017-6-7.
 */
object LoginContract {
    interface View : BaseMvpView{}

    interface Presenter : BaseMvpPresenter<View>{
        
    }
}
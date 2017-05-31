package com.francis.kotlinexample.mvp

/**
 * Created by Francis on 2017-5-31.
 * 基础presenter
 */
interface BaseMvpPresenter<in V: BaseMvpView> {
    fun attachView(view: V)

    fun detachView()
}
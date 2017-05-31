package com.francis.kotlinexample.mvp

/**
 * Created by Francis on 2017-5-31.
 * 用于继承basePresenter
 */
open class BaseMvpPresenterImpl<V : BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

}
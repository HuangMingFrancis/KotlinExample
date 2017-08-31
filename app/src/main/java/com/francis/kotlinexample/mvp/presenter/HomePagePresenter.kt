package com.francis.kotlinexample.mvp.presenter

import com.francis.kotlinexample.api.manager.KaiYanApiManager
import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl
import com.francis.kotlinexample.mvp.contract.HomePageContract
import rx.functions.Action1

/**
 * Created by Francis on 2017-8-30.
 */
class HomePagePresenter : BaseMvpPresenterImpl<HomePageContract.View>(), HomePageContract.Presenter{

    override fun getHomeData() {
        KaiYanApiManager.getHomeData()
                .subscribe(Action1 {
                    mView?.setData(it)
                }, Action1 {
                    mView?.showError(it.toString())
                })
    }

    override fun getHomeMoreData(date: String, num: String) {

        KaiYanApiManager.getHomeMoreData(date, num)
                .subscribe(Action1 {
                    mView?.setData(it)
                }, Action1 {
                    mView?.showError(it.toString())
                })
    }

}
package com.francis.kotlinexample.flow.splash

import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl

/**
 * Created by Francis on 2017-5-31.
 */
class SplashPresenter : BaseMvpPresenterImpl<SplashContract.View>(),
        SplashContract.Presenter{

    /**
     * 获得服务器版本号
     */
    override fun getServerAppVersion() {

    }

}
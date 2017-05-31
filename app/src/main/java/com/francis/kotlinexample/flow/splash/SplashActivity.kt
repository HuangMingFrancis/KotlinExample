package com.francis.kotlinexample.flow.splash

import android.os.Bundle
import com.francis.kotlinexample.R
import com.francis.kotlinexample.mvp.BaseMvpActivity
import com.francis.kotlinexample.util.sp.ProjectSPUtils

/**
 * 启动时的加载页
 */
class SplashActivity(override var mPresenter: SplashContract.Presenter = SplashPresenter()) :
        BaseMvpActivity<SplashContract.View, SplashContract.Presenter>(), SplashContract.View{

    var isFirstIn = false
    var isLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun initData() {
        readSharedPreferences()
    }

    override fun initListener() {
    }

    fun readSharedPreferences(){
        isFirstIn = ProjectSPUtils.getIsFirstLogin()
        isLogin = ProjectSPUtils.getIsLogin(false)

        showMessage("" + isFirstIn + " " + isLogin)
    }
}

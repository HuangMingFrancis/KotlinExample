package com.francis.kotlinexample.flow.splash

import android.os.Bundle
import com.francis.kotlinexample.R
import com.francis.kotlinexample.flow.login.LoginActivity
import com.francis.kotlinexample.mvp.BaseMvpActivity
import org.jetbrains.anko.startActivity
import java.util.*

/**
 * 启动时的加载页
 */
class SplashActivity(override var mPresenter: SplashContract.Presenter = SplashPresenter()) :
        BaseMvpActivity<SplashContract.View, SplashContract.Presenter>(), SplashContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun initData() {
        mPresenter.getServerAppVersion()
        gotoLogin()
    }

    override fun initListener() {
    }

    fun gotoLogin(){
        val task = MyTask()
        val time = Timer()
        time.schedule(task, 2000)
    }

    inner class MyTask : TimerTask(){
        override fun run() {
            startActivity<LoginActivity>()
        }

    }

}

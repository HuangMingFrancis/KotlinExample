package com.francis.kotlinexample.flow.login

import android.os.Bundle
import com.francis.kotlinexample.R
import com.francis.kotlinexample.mvp.BaseMvpActivity

/**
 * 登录界面
 */
class LoginActivity(override var mPresenter: LoginContract.Presenter = LoginPresenter())
    : BaseMvpActivity<LoginContract.View, LoginContract.Presenter>(), LoginContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}

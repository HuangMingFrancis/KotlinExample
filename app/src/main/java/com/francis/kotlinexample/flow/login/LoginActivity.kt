package com.francis.kotlinexample.flow.login

import android.os.Bundle
import android.view.View
import com.francis.kotlinexample.R
import com.francis.kotlinexample.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*

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
        login_btnLogin.setOnClickListener(View.OnClickListener {
            mPresenter.login(login_edtId.text.toString(), login_edtPwd.text.toString())
        })
    }
}

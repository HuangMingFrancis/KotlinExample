package com.francis.kotlinexample.ui.activity

import android.view.View
import com.francis.kotlinexample.R
import com.francis.kotlinexample.mvp.BaseMvpActivity
import com.francis.kotlinexample.mvp.contract.LoginContract
import com.francis.kotlinexample.mvp.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 登录界面
 */
class LoginActivity(override var mPresenter: LoginContract.Presenter = LoginPresenter())
    : BaseMvpActivity<LoginContract.View, LoginContract.Presenter>(), LoginContract.View {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData() {

    }

    override fun initListener() {
        login_btnLogin.setOnClickListener(View.OnClickListener {
            mPresenter.login(login_edtId.text.toString(), login_edtPwd.text.toString())
        })
    }
}

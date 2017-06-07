package com.francis.kotlinexample.flow.login

import android.text.TextUtils
import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl

/**
 * Created by Francis on 2017-6-7.
 */
class LoginPresenter : BaseMvpPresenterImpl<LoginContract.View>(), LoginContract.Presenter{
    companion object{
        private val LOGIN_ERROR_BY_NAME = "请输入手机号"
        private val LOGIN_ERROR_BY_PSW = "请输入验证码"
    }

    override fun login(loginName: String, loginPsw: String) {
        if (TextUtils.isEmpty(loginName)){
            mView?.showMessage(LOGIN_ERROR_BY_NAME)
            return
        }
        if (TextUtils.isEmpty(loginPsw)){
            mView?.showMessage(LOGIN_ERROR_BY_PSW)
            return
        }
    }
}
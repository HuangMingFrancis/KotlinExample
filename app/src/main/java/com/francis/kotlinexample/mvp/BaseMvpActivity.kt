package com.francis.kotlinexample.mvp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Francis on 2017-5-31.
 * 继承Activity
 */
abstract class BaseMvpActivity<V : BaseMvpView , T : BaseMvpPresenter<V>> :
                AppCompatActivity() , BaseMvpView{

    protected abstract var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)

    }

    override fun getContext(): Context {
        return this
    }

    override fun showError(error: String?, durationTime: Int) {
        Toast.makeText(this, error, durationTime).show()
    }

    override fun showError(stringResId: Int, durationTime: Int) {
        Toast.makeText(this, stringResId, durationTime).show()
    }

    override fun showMessage(message: String, durationTime: Int) {
        Toast.makeText(this, message, durationTime).show()
    }

    override fun showMessage(stringResId: Int, durationTime: Int) {
        Toast.makeText(this, stringResId, durationTime).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    override fun onResume() {
        super.onResume()
        initData()
        initListener()
    }

    abstract fun initData()

    abstract fun initListener()
}
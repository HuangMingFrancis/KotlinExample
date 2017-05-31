package com.francis.kotlinexample.mvp

import android.content.Context
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar

/**
 * Created by Francis on 2017-5-31.
 * View的基本方法
 */
interface BaseMvpView {
    fun getContext(): Context

    fun showError(error: String?, durationTime: Int = Snackbar.LENGTH_SHORT)

    fun showError(@StringRes stringResId: Int, durationTime: Int = Snackbar.LENGTH_SHORT)

    fun showMessage(message: String, durationTime: Int = Snackbar.LENGTH_SHORT)

    fun showMessage(@StringRes stringResId: Int, durationTime: Int = Snackbar.LENGTH_SHORT)
}
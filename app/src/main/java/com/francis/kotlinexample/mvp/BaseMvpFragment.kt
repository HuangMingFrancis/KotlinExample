package com.francis.kotlinexample.mvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by Francis on 2017-8-24.
 */
abstract class BaseMvpFragment<V : BaseMvpView , T : BaseMvpPresenter<V>> : Fragment(), BaseMvpView{
    protected abstract var mPresenter: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)
    }

    override fun getContext(): Context {
        return activity
    }

    override fun showError(error: String?, durationTime: Int) {
        Toast.makeText(activity, error, durationTime).show()
    }

    override fun showError(stringResId: Int, durationTime: Int) {
        Toast.makeText(activity, stringResId, durationTime).show()
    }

    override fun showMessage(message: String, durationTime: Int) {
        Toast.makeText(activity, message, durationTime).show()
    }

    override fun showMessage(stringResId: Int, durationTime: Int) {
        Toast.makeText(activity, stringResId, durationTime).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    var isFirst : Boolean = false
    var rootView : View? = null
    var isFragmentVisiable :Boolean = false
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(rootView==null){
            rootView = inflater?.inflate(getLayoutResources(),container,false)
        }
        return  rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isFragmentVisiable = true
        }
        if (rootView == null) {
            return
        }
        //可见，并且没有加载过
        if (!isFirst&&isFragmentVisiable) {
            onFragmentVisiableChange(true)
            return
        }
        //由可见——>不可见 已经加载过
        if (isFragmentVisiable) {
            onFragmentVisiableChange(false)
            isFragmentVisiable = false
        }
    }
    open protected fun onFragmentVisiableChange(b: Boolean) {

    }


    abstract fun getLayoutResources(): Int

    abstract fun initView()
}
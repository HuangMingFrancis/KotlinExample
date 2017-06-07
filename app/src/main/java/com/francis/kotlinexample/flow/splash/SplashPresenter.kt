package com.francis.kotlinexample.flow.splash

import android.text.TextUtils
import com.francis.kotlinexample.base.Constants
import com.francis.kotlinexample.manager.JLTApiManager
import com.francis.kotlinexample.model.AppVersionEntity
import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl
import rx.functions.Action1

/**
 * Created by Francis on 2017-5-31.
 */
class SplashPresenter : BaseMvpPresenterImpl<SplashContract.View>(),
        SplashContract.Presenter{

    companion object{
        private val appTypeCode = "01"
    }

    /**
     * 获得服务器版本号
     */
    override fun getServerAppVersion() {
        JLTApiManager.getAppVersion(appTypeCode)
                .subscribe(Action1 {
                    if (it.result){
                        handlerAppVersion(it.data)
                    } else {
                        mView?.showError(it.msg)
                    }
                }, Action1 {
                    mView?.showError(it.message)
                })
    }

    //记录版本信息
    fun handlerAppVersion(appVersionEntity: AppVersionEntity){
        if (appVersionEntity != null){
            if (!TextUtils.isEmpty(appVersionEntity.appVersionCode)){
                Constants.Update.serverVersion = appVersionEntity.appVersionCode.toDouble()
            }
            if (!TextUtils.isEmpty(appVersionEntity.appUpdateCode)){
                Constants.Update.isUpdate = when(appVersionEntity.appUpdateCode){
                    "01" -> false
                    "02" -> true
                    else -> false
                }
            }
            if (!TextUtils.isEmpty(appVersionEntity.appRemark)){
                Constants.Update.appRemark = appVersionEntity.appRemark
            }
        }
    }
}
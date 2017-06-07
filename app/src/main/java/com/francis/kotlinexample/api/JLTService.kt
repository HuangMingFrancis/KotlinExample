package com.francis.kotlinexample.api

import com.francis.kotlinexample.model.AppVersionEntity
import com.francis.kotlinexample.model.BaseRespEntity
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Francis on 2017-6-7.
 * JLT项目Service
 */
interface JLTService {

    //获得版本号
    @GET(ApiSettings.URL_GET_APP_VERSION)
    fun getAppVersion(@Query("condition.appTypeCode") appTypeCode: String):
            Observable<BaseRespEntity<AppVersionEntity>>

}
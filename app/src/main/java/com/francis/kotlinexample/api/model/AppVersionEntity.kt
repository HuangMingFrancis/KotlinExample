package com.francis.kotlinexample.api.model

/**
 * Created by Francis on 2017-6-7.
 * 版本号请求实体类
 */
data class AppVersionEntity(val appTypeCode: String,
                            val appTypeName: String,
                            val appVersionCode: String,
                            val appVersionName: String,
                            val appUpdateCode: String,
                            val appUpdateName: String,
                            val appRemark: String)
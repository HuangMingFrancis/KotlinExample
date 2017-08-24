package com.francis.kotlinexample.api.model

/**
 * Created by Francis on 2017-6-7.
 * 响应参数基类
 */
data class BaseRespEntity<T>(val result: Boolean,
                             val exception: Boolean,
                             val msg: String,
                             val data: T)
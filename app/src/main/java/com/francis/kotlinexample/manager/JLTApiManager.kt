package com.francis.kotlinexample.manager

import com.francis.kotlinexample.api.JLTService
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Francis on 2017-6-7.
 */
object JLTApiManager {
    private const val SERVER: String = "http://192.168.0.193:8080/jlt-mobile/"

    private lateinit var mService: JLTService

    init {
        initServices(initRetrofit())
    }

    private fun initRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            networkInterceptors().add(Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build()
                chain.proceed(request)
            })
            addInterceptor(interceptor)
        }

        return Retrofit.Builder().baseUrl(SERVER)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(createGsonConverter())
                .client(client.build())
                .build()
    }

    private fun createGsonConverter(): GsonConverterFactory {
        val builder = GsonBuilder().serializeNulls()
        return GsonConverterFactory.create(builder.create())
    }

    private fun initServices(retrofit: Retrofit){
        mService = retrofit.create(JLTService::class.java)
    }


    //获得版本号
    fun getAppVersion(appTypeCode: String) =
            mService.getAppVersion(appTypeCode)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}
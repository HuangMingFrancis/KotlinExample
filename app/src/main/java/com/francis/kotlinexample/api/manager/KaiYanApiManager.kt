package com.francis.kotlinexample.api.manager

import com.francis.kotlinexample.api.KaiYanApiService
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
 * Created by Francis on 2017-8-25.
 */
object KaiYanApiManager {
    private const val SERVER: String = "http://baobab.kaiyanapp.com/api/"

    private lateinit var mService: KaiYanApiService

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
        val gson = GsonBuilder().setLenient().create()
        return GsonConverterFactory.create(gson)
    }

    private fun initServices(retrofit: Retrofit){
        mService = retrofit.create(KaiYanApiService::class.java)
    }

    fun getHomeData() =
            mService.getHomeData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    fun getHomeMoreData(date: String, num: String) =
            mService.getHomeMoreData(date, num)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}
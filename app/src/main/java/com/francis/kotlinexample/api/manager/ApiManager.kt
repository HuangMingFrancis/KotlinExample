package com.francis.kotlinexample.api.manager

import com.francis.kotlinexample.api.GithubService
import com.francis.kotlinexample.api.model.RepositoryDetail
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Francis on 2017-5-31.
 * Api操作类
 */
object ApiManager {
    private const val SERVER: String = "https://api.github.com/"

    private lateinit var mGithubService: GithubService

    init {
        initServices(initRetrofit())
    }

    private fun initRetrofit(): Retrofit{
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

    private fun createGsonConverter(): GsonConverterFactory{
        val builder = GsonBuilder().serializeNulls()
        return GsonConverterFactory.create(builder.create())
    }

    private fun initServices(retrofit: Retrofit){
        mGithubService = retrofit.create(GithubService::class.java)
    }

    fun loadOrganizationRepos(organizationName: String, reposType: String) =
            mGithubService.getOrganizationRepos(organizationName, reposType)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    fun loadRepository(owner: String, name: String): Observable<RepositoryDetail>{
        return mGithubService.getRepository(owner, name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}
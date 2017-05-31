package com.francis.kotlinexample.flow.repository

import com.francis.kotlinexample.manager.ApiManager
import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl
import rx.functions.Action1
import rx.lang.kotlin.onError

/**
 * Created by Francis on 2017-5-31.
 */
class RepositoryDetailsPresenter : BaseMvpPresenterImpl<RepositoryDetailsContract.View>(),
        RepositoryDetailsContract.Presenter {
    companion object {
        private const val ORGANIZATION_NAME = "Yalantis"
    }

    override fun loadRepositoryDetail(name: String) {
        mView?.showProgress()
        ApiManager.loadRepository(ORGANIZATION_NAME, name)
                .onError {
                    mView?.hideProgress()
                    mView?.showError(it.toString())
                }
                .subscribe(Action1 {
                    mView?.hideProgress()
                    mView?.showRepositoryDetail(it)
                })
    }

}
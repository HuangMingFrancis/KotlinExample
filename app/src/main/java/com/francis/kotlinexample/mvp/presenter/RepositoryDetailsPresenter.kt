package com.francis.kotlinexample.mvp.presenter

import com.francis.kotlinexample.api.manager.ApiManager
import com.francis.kotlinexample.mvp.contract.RepositoryDetailsContract
import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl
import rx.functions.Action0
import rx.functions.Action1

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
                .subscribe(Action1 {
                    mView?.showRepositoryDetail(it)
                }, Action1 {
                    mView?.showError(it.message)
                }, Action0 {
                    mView?.hideProgress()
                })

    }

}
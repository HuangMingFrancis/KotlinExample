package com.francis.kotlinexample.flow.repository_list

import com.francis.kotlinexample.manager.ApiManager
import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl
import rx.functions.Action1

/**
 * Created by Francis on 2017-5-31.
 */
class RepositoriesPresenter : BaseMvpPresenterImpl<RepositoriesContract.View>(),
        RepositoriesContract.Presenter{

    companion object {
        private val ORGANIZATION_NAME = "Yalantis"
        private val REPOS_TYPE = "public"
    }

    override fun loadRepositories() {
        mView?.showProgress()
        ApiManager.loadOrganizationRepos(ORGANIZATION_NAME, REPOS_TYPE)
                .doOnError {
                    mView?.hideProgress()
                    mView?.showError(it.toString()) }
                .subscribe(Action1 {
                    mView?.hideProgress()
                    mView?.showOrganizations(it)
                })
    }
}
package com.francis.kotlinexample.mvp.contract

import com.francis.kotlinexample.api.model.RepositoryDetail
import com.francis.kotlinexample.mvp.BaseMvpPresenter
import com.francis.kotlinexample.mvp.BaseMvpView

/**
 * Created by Francis on 2017-5-31.
 */
object RepositoryDetailsContract {
    interface View : BaseMvpView {

        fun showProgress()
        fun hideProgress()
        fun showRepositoryDetail(repositoryDetail: RepositoryDetail)
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadRepositoryDetail(name: String)
    }
}
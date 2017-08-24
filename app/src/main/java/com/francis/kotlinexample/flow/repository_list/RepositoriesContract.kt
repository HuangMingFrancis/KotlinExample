package com.francis.kotlinexample.flow.repository_list

import com.francis.kotlinexample.api.model.Repository
import com.francis.kotlinexample.mvp.BaseMvpPresenter
import com.francis.kotlinexample.mvp.BaseMvpView

/**
 * Created by Francis on 2017-5-31.
 * 显示资源列表界面的Contrack
 */
object RepositoriesContract {

    interface View : BaseMvpView{
        fun showOrganizations(repositors: MutableList<Repository>)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter : BaseMvpPresenter<View> {
        fun loadRepositories()
    }
}
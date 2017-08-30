package com.francis.kotlinexample.ui.fragment

import com.francis.kotlinexample.R
import com.francis.kotlinexample.api.model.HomeBean.IssueListBean.ItemListBean
import com.francis.kotlinexample.mvp.BaseMvpFragment
import com.francis.kotlinexample.mvp.contract.HomePageContract
import com.francis.kotlinexample.mvp.presenter.HomePagePresenter
import java.util.*

/**
 * Created by Francis on 2017-8-24.
 */
class HomeFragment(override var mPresenter: HomePageContract.Presenter = HomePagePresenter()) :
        BaseMvpFragment<HomePageContract.View, HomePageContract.Presenter>(), HomePageContract.View{

    var mIsRefresh: Boolean = false
    var mList = ArrayList<ItemListBean>()

    override fun getLayoutResources(): Int {
        return R.layout.fragment_home_page
    }

    override fun initView() {

    }

}
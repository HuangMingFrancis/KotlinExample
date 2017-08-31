package com.francis.kotlinexample.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.francis.kotlinexample.R
import com.francis.kotlinexample.api.model.HomeBean
import com.francis.kotlinexample.api.model.HomeBean.IssueListBean.ItemListBean
import com.francis.kotlinexample.mvp.BaseMvpFragment
import com.francis.kotlinexample.mvp.contract.HomePageContract
import com.francis.kotlinexample.mvp.presenter.HomePagePresenter
import com.francis.kotlinexample.ui.adapter.HomePageAdapter
import kotlinx.android.synthetic.main.fragment_home_page.*
import java.util.*
import java.util.regex.Pattern

/**
 * Created by Francis on 2017-8-24.
 */
class HomeFragment(override var mPresenter: HomePageContract.Presenter = HomePagePresenter()) :
        BaseMvpFragment<HomePageContract.View, HomePageContract.Presenter>(), HomePageContract.View, SwipeRefreshLayout.OnRefreshListener{
    var mIsRefresh: Boolean = false
    var mList = ArrayList<ItemListBean>()
    var mAdapter: HomePageAdapter? = null
    var data: String ?= null

    override fun getLayoutResources(): Int {
        return R.layout.fragment_home_page
    }

    override fun initView() {

        mPresenter?.getHomeData()
        recyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = HomePageAdapter(context, mList, {

        })
        recyclerView.adapter = mAdapter
        refreshLayout.setOnRefreshListener(this)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPositon == mList.size - 1) {
                    if (data != null) {
                        mPresenter?.getHomeMoreData(data.toString())
                    }

                }
            }
        })

    }


    override fun setData(homeBean: HomeBean) {

        val regEx = "[^0-9]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(homeBean?.nextPageUrl)
        data = m.replaceAll("").subSequence(1, m.replaceAll("").length - 1).toString()
        if (mIsRefresh) {
            mIsRefresh = false
            refreshLayout.isRefreshing = false
            if (mList.size > 0) {
                mList.clear()
            }

        }
        homeBean.issueList!!
                .flatMap { it.itemList!! }
                .filter { it.type.equals("video") }
                .forEach { mList.add(it) }
        mAdapter?.notifyDataSetChanged()
    }

    override fun onRefresh() {
    }

}
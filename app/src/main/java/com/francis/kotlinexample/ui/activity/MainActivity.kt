package com.francis.kotlinexample.ui.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.francis.kotlinexample.R
import com.francis.kotlinexample.api.model.Repository
import com.francis.kotlinexample.flow.repository_list.RepositoriesContract
import com.francis.kotlinexample.flow.repository_list.RepositoriesPresenter
import com.francis.kotlinexample.mvp.BaseMvpActivity
import com.francis.kotlinexample.ui.adapter.RepositoriesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity(override var mPresenter: RepositoriesPresenter = RepositoriesPresenter()) :
        BaseMvpActivity<RepositoriesContract.View, RepositoriesPresenter>(),
        RepositoriesContract.View {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    private var mAdapter: RepositoriesAdapter? = null

    private var repositories: MutableList<Repository> = ArrayList<Repository>()

    override fun initData() {
        title = getString(R.string.title_activity_repositories)
        mPresenter.loadRepositories()

        initAdapter()
    }

    override fun initListener() {
        fab.setOnClickListener {
            mPresenter.loadRepositories()
        }
    }

    override fun showOrganizations(repositories: MutableList<Repository>) {
        this.repositories.clear()
        this.repositories.addAll(repositories)
        mAdapter?.notifyDataSetChanged()
    }

    /**
     * 显示加载框
     */
    override fun showProgress(){
        recyclerViewRepositories.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        fab.isEnabled = false
    }

    /**
     * 隐藏加载框
     */
    override fun hideProgress(){
        recyclerViewRepositories.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        fab.isEnabled = true
    }

    private fun initAdapter(){
        mAdapter = RepositoriesAdapter(repositories, {
            var intent = Intent(getContext(), RepositoryDetailActivity::class.java)
            intent.putExtra(RepositoryDetailActivity.NAME, it.name)
            startActivity(intent)
        })
        recyclerViewRepositories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewRepositories.adapter = mAdapter
    }
}

package com.francis.kotlinexample.flow.repository

import android.os.Bundle
import android.view.View
import client.yalantis.com.githubclient.formatDate
import com.francis.kotlinexample.R
import com.francis.kotlinexample.model.RepositoryDetail
import com.francis.kotlinexample.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_repository_detail.*

class RepositoryDetailActivity(override var mPresenter: RepositoryDetailsContract.Presenter = RepositoryDetailsPresenter())
            : BaseMvpActivity<RepositoryDetailsContract.View,
            RepositoryDetailsContract.Presenter>(), RepositoryDetailsContract.View {

    override fun initData() {
        toolbar.title = getString(R.string.title_activity_details)
        mPresenter.loadRepositoryDetail(intent.getStringExtra(NAME))
    }

    override fun initListener() {
    }

    companion object {
        const val NAME = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository_detail)

    }

    override fun showProgress() {
        layoutContent.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        layoutContent.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showRepositoryDetail(repositoryDetail: RepositoryDetail) {
        with(repositoryDetail) {
            repositoryName.text = name
            textCreatedDate.text = created_at.formatDate()
            textUpdatedDate.text = updated_at.formatDate()
            textDescription.text = description
            textForks.text = forks_count
            textStars.text = stargazers_count
        }
    }
}

package com.francis.kotlinexample.mvp.presenter

import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl
import com.francis.kotlinexample.mvp.contract.HomePageContract

/**
 * Created by Francis on 2017-8-30.
 */
class HomePagePresenter : BaseMvpPresenterImpl<HomePageContract.View>(), HomePageContract.Presenter{

}
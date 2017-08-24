package com.francis.kotlinexample.flow.home

import com.francis.kotlinexample.mvp.BaseMvpPresenterImpl
import java.util.*

/**
 * Created by Francis on 2017-8-22.
 */
class HomePresenter : BaseMvpPresenterImpl<HomeContract.View>(), HomeContract.Presenter {

    override fun getToday(): String {
        var list = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        var data: Date = Date()
        var calendar: Calendar = Calendar.getInstance()
        calendar.time = data
        var index: Int = calendar.get(Calendar.DAY_OF_WEEK) - 1
        if (index < 0) {
            index = 0
        }
        return list[index]
    }
}
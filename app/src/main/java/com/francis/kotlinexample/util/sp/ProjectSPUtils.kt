package com.francis.kotlinexample.util.sp

import com.francis.kotlinexample.base.Constants
/**
 * Created by Francis on 2017-5-31.
 */
object ProjectSPUtils {
    fun getIsFirstLogin(): Boolean {
        return MaSPUtils.get(Constants.SharedPreferences.SF_KEY_FIRST_LOGIN,true) as Boolean
    }


    fun getIsLogin(defaultValue: Boolean): Boolean =
            MaSPUtils.get(Constants.SharedPreferences.SF_KEY_LOGIN_STATUS, defaultValue) as Boolean
}


package com.francis.kotlinexample.base

/**
 * @author: Felix Shi
 * *
 * @date: 2015/8/14 21:46
 * *
 * @Description: 常量
 */
object Constants {

    // 工程相关常量
    object Project {
        val ProjectName = "GYMamsf"
    }

    // SharedPreferences相关常量
    object SharedPreferences {
        val SharedPreferencesName = Project.ProjectName + ".sp"
        val XxxKey = "key"

        val SF_KEY_FIRST_LOGIN = "first_login"
        val SF_KEY_LOGIN_STATUS = "login"// 已登录状态
    }

    object Update{
        var localVersion = 0
        var localVersionName = "1.0.0"
        var serverVersion = 0.0
        var isUpdate = false
        var appRemark = "新版本信息!"
        val DOWNLOAD_DIR = "app/download/"
    }
}

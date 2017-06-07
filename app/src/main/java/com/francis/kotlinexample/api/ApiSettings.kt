package com.francis.kotlinexample.api

/**
 * Created by Francis on 2017-5-31.
 * api网址参数
 */
object ApiSettings {
    const val PATH_ORGANIZATION = "organization"
    const val PAPAM_REPOS_TYPE = "type"

    const val PATH_REPO = "repo"
    const val PATH_OWNER = "owner"

    const val ORGANIZATION_REPOS = "orgs/{$PATH_ORGANIZATION}/repos"
    const val REPOSITORY = "/repos/{$PATH_OWNER}/{$PATH_REPO}"

    //获得版本号
    const val URL_GET_APP_VERSION = "mobile/common/getAppVersion.shtml"


}
package com.francis.kotlinexample.api

import com.francis.kotlinexample.api.model.Repository
import com.francis.kotlinexample.api.model.RepositoryDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Francis on 2017-5-31.
 * 访问的接口
 */
interface GithubService {

    @GET(ApiSettings.ORGANIZATION_REPOS)
    fun getOrganizationRepos(@Path(ApiSettings.PATH_ORGANIZATION) organizationName: String,
                             @Query(ApiSettings.PAPAM_REPOS_TYPE) reposType: String): Observable<MutableList<Repository>>

    @GET(ApiSettings.REPOSITORY)
    fun getRepository(@Path(ApiSettings.PATH_OWNER) owner: String,
                      @Path(ApiSettings.PATH_REPO) name: String): Observable<RepositoryDetail>
}
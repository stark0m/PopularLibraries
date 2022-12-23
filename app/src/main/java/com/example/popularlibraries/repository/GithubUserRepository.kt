package com.mirkhusainov.geekbrainscourse.repository

import com.mirkhusainov.geekbrainscourse.model.GithubRepo
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubUserRepository {
    fun getUserRepositoryList(login:String): Single<List<GithubRepo>>
}
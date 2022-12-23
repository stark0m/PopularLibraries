package com.example.popularlibraries.repository

import com.mirkhusainov.geekbrainscourse.core.mapper.ReposMapper
import com.mirkhusainov.geekbrainscourse.core.network.UsersApi
import com.mirkhusainov.geekbrainscourse.model.GithubRepo
import com.mirkhusainov.geekbrainscourse.repository.GithubUserRepository
import io.reactivex.rxjava3.core.Single

class GithubUserRepositoryRetrofitImpl constructor(
    private val usersApi: UsersApi
):GithubUserRepository {
    override fun getUserRepositoryList(login: String): Single<List<GithubRepo>> {
        return usersApi.getRepos(login)
            .map { it.map(ReposMapper::map) }
    }

}
package com.example.popularlibraries.repository

import GithubRepo
import GithubUserRepository
import ReposMapper
import UsersApi
import io.reactivex.rxjava3.core.Single

class GithubUserRepositoryRetrofitImpl constructor(
    private val usersApi: UsersApi
):GithubUserRepository {
    override fun getUserRepositoryList(login: String): Single<List<GithubRepo>> {
        return usersApi.getRepos(login)
            .map { it.map(ReposMapper::map) }
    }

}
package com.example.popularlibraries.repository.retrofitimpl

import GithubRepository
import GithubUser
import UserDAO
import UserMapper
import UsersApi
import com.example.popularlibraries.utils.doCompletableIf

import io.reactivex.rxjava3.core.Single

class GithubRepositoryRetrofitImpl constructor(
    private val usersApi: UsersApi,
    private val userDao: UserDAO,
    private val networkStatus: Single<Boolean>
) : GithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {
        return networkStatus.flatMap { hasConnection ->
            if (hasConnection) {
                fetchFromApi(true)
            } else {
                getFromDb()
            }
        }
    }


    private fun fetchFromApi(shouldPersist: Boolean): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .doCompletableIf(shouldPersist) {
                userDao.insertAll(it.map(UserMapper::mapToDBObject))
            }
            .map { it.map(UserMapper::mapToEntity) }

    }

    private fun getFromDb(): Single<List<GithubUser>> {
        return userDao.queryForAllUsers().map { it.map(UserMapper::mapToEntity) }
    }
}
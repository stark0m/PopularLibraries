package com.example.popularlibraries.repository.retrofitimpl

import com.example.popularlibraries.utils.doCompletableIf
import com.mirkhusainov.geekbrainscourse.core.mapper.UserMapper
import com.mirkhusainov.geekbrainscourse.core.network.UsersApi
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import com.mirkhusainov.geekbrainscourse.repository.GithubRepository
import io.reactivex.rxjava3.core.Single

class GithubRepositoryRetrofitImpl constructor(
    private val usersApi: UsersApi,
    private val networkStatus: Single<Boolean>
) : GithubRepository {
    override fun getUsers(): Single<List<GithubUser>> {


        val result = usersApi.getAllUsers()
            .map { it.map(UserMapper::mapToEntity) }
        return result
    }
}

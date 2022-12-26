package com.example.popularlibraries.repository.retrofitimpl

import com.example.popularlibraries.GeekBrainsApp
import com.example.popularlibraries.utils.doCompletableIf
import com.example.popularlibraries.utils.isOnline
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
        return when (isOnline(GeekBrainsApp.instance.applicationContext)){
            true -> usersApi.getAllUsers()
                .map { it.map(UserMapper::mapToEntity) }
            false -> usersApi.getAllUsers()
                .map { it.map(UserMapper::mapToEntity) }
        }
    }
}

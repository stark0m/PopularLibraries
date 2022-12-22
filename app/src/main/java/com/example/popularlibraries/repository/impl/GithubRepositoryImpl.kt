package com.mirkhusainov.geekbrainscourse.repository.impl

import com.mirkhusainov.geekbrainscourse.model.GithubUser
import com.mirkhusainov.geekbrainscourse.repository.GithubRepository
import io.reactivex.rxjava3.core.Single

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser(1,"asd",""),
        GithubUser(2,"asd","")
    )

    override fun getUsers(): Single<List<GithubUser>> {
        return Single.create(){
            it.onSuccess(repositories)
        }
    }
}
package com.mirkhusainov.geekbrainscourse.repository

import com.mirkhusainov.geekbrainscourse.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>
}
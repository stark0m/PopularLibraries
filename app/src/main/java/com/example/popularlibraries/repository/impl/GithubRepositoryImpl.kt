package com.mirkhusainov.geekbrainscourse.repository.impl

import com.mirkhusainov.geekbrainscourse.model.GithubUser
import com.mirkhusainov.geekbrainscourse.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val repositories = listOf(
        GithubUser("MrFox"),
        GithubUser("VictorMelnik"),
        GithubUser("Denix"),
        GithubUser("DmitryWb"),
        GithubUser("Larisa")
    )

    override fun getUsers(): List<GithubUser> {
        return repositories
    }
}
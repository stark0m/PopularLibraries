package com.mirkhusainov.geekbrainscourse.repository

import com.mirkhusainov.geekbrainscourse.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}
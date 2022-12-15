package com.example.popularlibraries.model

import com.mirkhusainov.geekbrainscourse.model.GithubUser

fun interface RecyclerItemClick {
    fun onItemClick(user:GithubUser)
}
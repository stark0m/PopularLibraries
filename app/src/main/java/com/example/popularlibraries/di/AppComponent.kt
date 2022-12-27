package com.example.popularlibraries.di

import com.example.popularlibraries.MainActivity
import com.mirkhusainov.geekbrainscourse.core.network.UsersApi
import com.mirkhusainov.geekbrainscourse.repository.GithubUserRepository
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun getUsersRepo(): GithubUserRepository
    fun inject(activity:MainActivity)

}
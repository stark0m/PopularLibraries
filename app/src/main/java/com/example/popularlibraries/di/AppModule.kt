package com.example.popularlibraries.di

import com.example.popularlibraries.repository.GithubUserRepositoryRetrofitImpl
import com.mirkhusainov.geekbrainscourse.core.network.NetworkProvider
import com.mirkhusainov.geekbrainscourse.core.network.UsersApi
import com.mirkhusainov.geekbrainscourse.repository.GithubUserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Scope
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideUserApi():UsersApi{
        return NetworkProvider.usersApi
    }

    @Provides
    @Singleton
    fun provideGithubRetrofitRepository(userApi:UsersApi):GithubUserRepository{
        return GithubUserRepositoryRetrofitImpl(userApi)
    }
}
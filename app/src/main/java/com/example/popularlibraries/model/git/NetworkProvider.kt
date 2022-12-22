package com.mirkhusainov.geekbrainscourse.core.network


import com.example.popularlibraries.utils.GIT_API_URL
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkProvider {

    val usersApi by lazy { createRetrofit().create(UsersApi::class.java) }

    private fun createGson() = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    private fun createRetrofit() = Retrofit.Builder()
        .client(createClient())
        .baseUrl(GIT_API_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(createGson()))
        .build()

    private fun createClient() = OkHttpClient
        .Builder()
        .build()
}
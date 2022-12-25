package com.example.popularlibraries

import GithubAppDb
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.popularlibraries.utils.ConnetivityListener
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class GeekBrainsApp : Application() {

    companion object {
        lateinit var instance: GeekBrainsApp
    }

    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }
    private lateinit var connetivityListener: ConnetivityListener
    val database: GithubAppDb by lazy { GithubAppDb.create(this) }
    val navigationHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router


    override fun onCreate() {
        super.onCreate()
        instance = this




        connetivityListener = ConnetivityListener(
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        )

        RxJavaPlugins.setErrorHandler {
        }
    }
    fun getConnectObservable() = connetivityListener.status()
    fun getConnectSingle() = connetivityListener.statusSingle()
}
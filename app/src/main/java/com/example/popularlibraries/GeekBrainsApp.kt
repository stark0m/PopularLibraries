package com.example.popularlibraries

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.example.popularlibraries.core.database.GithubAppDb
import com.example.popularlibraries.di.AppComponent
import com.example.popularlibraries.di.DaggerAppComponent
import com.example.popularlibraries.utils.ConnetivityListener
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.mirkhusainov.geekbrainscourse.main.MainPresenter

class GeekBrainsApp : Application() {

    companion object {
        lateinit var  instance:GeekBrainsApp
    }


    lateinit var appComponent: AppComponent
    private val cicerone: Cicerone<Router> by lazy { Cicerone.create() }
    val router by lazy { cicerone.router }
    val database: GithubAppDb by lazy { GithubAppDb.create(this) }

    private lateinit var connetivityListener: ConnetivityListener
    val navigationHolder = cicerone.getNavigatorHolder()


    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.create()

        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connetivityListener = ConnetivityListener(connectivityManager)
    }

    fun getConnectObservable() = connetivityListener.status()
    fun getConnectSingle() = connetivityListener.statusSingle()
}
package com.example.popularlibraries.utils

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.PublishSubject

class ConnetivityListener(connectivityManager: ConnectivityManager) {

    private val subject = PublishSubject.create<Boolean>()

    init {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    subject.onNext(true)
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    subject.onNext(true)
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    subject.onNext(true)
                }
            } else {
                subject.onNext(false)
            }





    }

    fun status(): Observable<Boolean> = subject

    fun statusSingle(): Single<Boolean> = subject.first(false)
}
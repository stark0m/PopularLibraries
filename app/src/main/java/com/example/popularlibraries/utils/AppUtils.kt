package com.example.popularlibraries.utils

import android.view.View
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

const val GIT_API_URL = "https://api.github.com/"

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun <T> Single<T>.doCompletableIf(
    predicate: Boolean,
    completableCreater: (data: T) -> Completable
): Single<T> {
    return if (predicate) {
        this.flatMap {
            completableCreater(it).andThen(Single.just(it))
        }
    } else {
        this
    }
}
package com.example.popularlibraries.utils

import android.view.View

const val GIT_API_URL = "https://api.github.com/"

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}
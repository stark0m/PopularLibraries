package com.mirkhusainov.geekbrainscourse.main

import com.github.terrakok.cicerone.Router
import com.mirkhusainov.geekbrainscourse.core.nav.UserInformationScreen
import com.mirkhusainov.geekbrainscourse.core.nav.UsersScreen
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }


}
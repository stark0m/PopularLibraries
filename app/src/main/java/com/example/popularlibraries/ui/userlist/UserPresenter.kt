package com.mirkhusainov.geekbrainscourse.user

import com.github.terrakok.cicerone.Router
import com.mirkhusainov.geekbrainscourse.core.nav.UserInformationScreen
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import com.mirkhusainov.geekbrainscourse.repository.GithubRepository
import moxy.MvpPresenter

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    lateinit var userToShow:GithubUser
    private set

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    fun showUserInfo(user: GithubUser){
        userToShow = user
        router.navigateTo(UserInformationScreen(user))
    }
}
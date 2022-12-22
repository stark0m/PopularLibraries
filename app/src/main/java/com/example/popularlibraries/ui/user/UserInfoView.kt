package com.example.popularlibraries.ui.user


import com.mirkhusainov.geekbrainscourse.model.GithubRepo
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface UserInfoView : MvpView {
    fun showUserInfo(user:GithubUser)
    fun showRepoList(list:List<GithubRepo>)
    fun showLoading()
    fun hideLoading()
}
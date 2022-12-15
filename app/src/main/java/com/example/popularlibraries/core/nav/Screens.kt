package com.mirkhusainov.geekbrainscourse.core.nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.popularlibraries.ui.user.UserInfoFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import com.mirkhusainov.geekbrainscourse.user.UserFragment

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

class UserInformationScreen(val user: GithubUser) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserInfoFragment.newInstance(user)
    }
}
package com.example.popularlibraries.ui.user

import UserInfoPresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.example.popularlibraries.GeekBrainsApp
import com.example.popularlibraries.databinding.FragmentUserInfoBinding
import com.example.popularlibraries.repository.GithubUserRepositoryRetrofitImpl
import com.example.popularlibraries.utils.makeGone
import com.example.popularlibraries.utils.makeVisible
import com.mirkhusainov.geekbrainscourse.core.OnBackPressedListener
import com.mirkhusainov.geekbrainscourse.core.network.NetworkProvider
import com.mirkhusainov.geekbrainscourse.model.GithubRepo
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import moxy.MvpAppCompatFragment

class UserInfoFragment() : MvpAppCompatFragment(), UserInfoView, OnBackPressedListener {

    private val ARG_LOGIN = "GitUSER"
    private var userInfo: GithubUser = GithubUser(1, "Start", "")
    private lateinit var binding: FragmentUserInfoBinding
    private lateinit var userinfoPresenter: UserInfoPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userInfo = arguments?.getParcelable<GithubUser>(ARG_LOGIN) ?: GithubUser(1, "Start", "")
        userinfoPresenter = UserInfoPresenter(
            GithubUserRepositoryRetrofitImpl(NetworkProvider.usersApi),
            this,
            userInfo
        )
        userinfoPresenter.showUserInfoPresenterCommand()
    }

    override fun showUserInfo(user: GithubUser) {
        Toast.makeText(requireContext(), "eeee", Toast.LENGTH_SHORT).show()
        binding.userInfo.text = userInfo.login
        binding.userAvatar.load(userInfo.avatarUrl)
    }

    override fun showRepoList(list: List<GithubRepo>) {
        Toast.makeText(requireContext(), "ffff", Toast.LENGTH_SHORT).show()
        //todo
    }

    companion object {
        fun newInstance(user: GithubUser) =
            UserInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_LOGIN, user)
                }
            }
    }

    override fun showLoading() {
        binding.progress.makeVisible()
    }

    override fun hideLoading() {
        binding.progress.makeGone()
    }

    override fun onBackPressed() = userinfoPresenter.onBackPressed()
}

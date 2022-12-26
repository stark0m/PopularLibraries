package com.mirkhusainov.geekbrainscourse.user

import UserPresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.databinding.FragmentUserListBinding
import com.example.popularlibraries.GeekBrainsApp
import com.example.popularlibraries.repository.retrofitimpl.GithubRepositoryRetrofitImpl
import com.mirkhusainov.geekbrainscourse.core.OnBackPressedListener
import com.mirkhusainov.geekbrainscourse.core.network.NetworkProvider

import com.mirkhusainov.geekbrainscourse.main.UserAdapter
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener {

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    private lateinit var viewBinding: FragmentUserListBinding

    private val adapter = UserAdapter {
        presenter.showUserInfo(it)
    }
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            GithubRepositoryRetrofitImpl(
                NetworkProvider.usersApi,
                GeekBrainsApp.instance.getConnectSingle()
            ),
            GeekBrainsApp.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun onBackPressed() = presenter.onBackPressed()
}

package com.example.popularlibraries.ui.user

import UserInfoPresenter
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.popularlibraries.databinding.FragmentUserInfoBinding
import com.example.popularlibraries.repository.GithubUserRepositoryRetrofitImpl
import com.example.popularlibraries.utils.makeGone
import com.example.popularlibraries.utils.makeVisible
import com.mirkhusainov.geekbrainscourse.core.network.NetworkProvider
import com.mirkhusainov.geekbrainscourse.model.GithubRepo
import com.mirkhusainov.geekbrainscourse.model.GithubUser
import moxy.MvpAppCompatFragment

class UserInfoFragment() : MvpAppCompatFragment(), UserInfoView {

    private val ARG_LOGIN = "GitUSER"
    private var userInfo: GithubUser = GithubUser(1, "Start", "")
    private lateinit var binding: FragmentUserInfoBinding
    private lateinit var userinfoPresenter: UserInfoPresenter
    private val adapter: ReposAdapter by lazy {
        ReposAdapter {
            userinfoPresenter.onClickGitRepository(it)
        }
    }

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
        initRecyclerView()
        userinfoPresenter.showUserInfoPresenterCommand()
    }

    private fun initRecyclerView() {
        binding.userRepositories.layoutManager = LinearLayoutManager(requireContext())
        binding.userRepositories.adapter = adapter
    }

    override fun showUserInfo(user: GithubUser) {
        binding.userInfo.text = userInfo.login
        binding.userAvatar.load(userInfo.avatarUrl)

    }

    override fun showRepoList(list: List<GithubRepo>) {
        adapter.repos = list
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

    override fun showRepositoryForksInfo(item: GithubRepo) {
        showDialogWithRepositoryForksInfo(item)
    }

    private fun showDialogWithRepositoryForksInfo(item: GithubRepo) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(item.name)
        builder.setMessage("Has total ${item.forks} forks")
        builder.show()
    }
}

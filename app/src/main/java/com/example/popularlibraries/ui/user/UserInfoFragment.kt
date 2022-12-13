package com.example.popularlibraries.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentUserInfoBinding
import com.mirkhusainov.geekbrainscourse.model.GithubUser

class UserInfoFragment() : Fragment() {

    private var userInfo: GithubUser = GithubUser("Start")
    private lateinit var binding: FragmentUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userInfo.text=userInfo.login
    }

    companion object {

        @JvmStatic
        fun newInstance(user: GithubUser) =
            UserInfoFragment().apply {
                userInfo = user
            }
            }
    }

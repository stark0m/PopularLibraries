package com.example.popularlibraries.ui.rxexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibraries.GeekBrainsApp
import com.example.popularlibraries.databinding.FragmentRxExampleBinding
import com.mirkhusainov.geekbrainscourse.repository.impl.GithubRepositoryImpl
import com.mirkhusainov.geekbrainscourse.user.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.io.File
import java.io.FileOutputStream
import java.lang.Error


class RxExample : MvpAppCompatFragment(), RxExampleVievInterface {
    private var _binding: FragmentRxExampleBinding? = null
    private val binding get() = _binding!!
    private val presenter: RxExamplePresenter by moxyPresenter {
        RxExamplePresenter(GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRxExampleBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.showImageButton.setOnClickListener {
            presenter.getJpgConvetToPngAndShowImage()
        }


    }


    companion object {

        fun newInstance() =
            RxExample()
    }

    override fun showImage(pathName: Drawable) {
        binding.imageView.setImageDrawable(pathName)
    }
}

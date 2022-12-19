package com.example.popularlibraries.ui.rxexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibraries.R
import com.example.popularlibraries.databinding.FragmentRxExampleBinding

var binding: FragmentRxExampleBinding? = null

class RxExample : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRxExampleBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    companion object {

        fun newInstance() =
            RxExample()
    }
}

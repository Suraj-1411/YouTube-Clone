package com.example.youtubeclone.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.youtubeclone.R
import com.example.youtubeclone.databinding.FragmentSplashBinding
import com.example.youtubeclone.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash){

    lateinit var mBinding : FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentSplashBinding.bind(view)

        Handler(Looper.myLooper()!!).postDelayed(
            {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            },2000
        )

    }
}
package com.example.youtubeclone.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.youtubeclone.R
import com.example.youtubeclone.data.models.User
import com.example.youtubeclone.databinding.FragmentHomeBinding
import com.example.youtubeclone.ui.base.BaseFragment
import com.example.youtubeclone.util.Resource
import com.example.youtubeclone.util.hide
import com.example.youtubeclone.util.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel:HomeViewModel by viewModels()
    private lateinit var mBinding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentHomeBinding.bind(view)

        initObservers()

        viewModel.getData()
    }

    private fun initObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Failure -> {
                    mBinding.progressBar.hide()
                    mBinding.outputTv.text = it.message
                }
                is Resource.Loading -> {
                    mBinding.progressBar.show()
                }
                is Resource.Success -> {
                    val user = it.data
                    mBinding.progressBar.hide()

                    val builder = StringBuilder()
                    builder.append("User id : ${user?.userId} \n\n")
                    builder.append("UserName : ${user?.title} \n\n")
                    builder.append("Body : ${user?.body}")

                    mBinding.outputTv.text = builder.toString()
                }
            }
        }
    }


}
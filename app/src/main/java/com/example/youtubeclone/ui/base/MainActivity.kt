package com.example.youtubeclone.ui.base

import android.os.Bundle
import com.example.youtubeclone.databinding.ActivityMainBinding
import com.example.youtubeclone.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}
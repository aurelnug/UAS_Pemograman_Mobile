package com.example.uas_pemograman_mobile.ui.Inews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uas_pemograman_mobile.databinding.FragmentInewsDetailBinding
import com.example.uas_pemograman_mobile.ui.MyViewModel

class InewsDetailFragment: Fragment() {
    private val viewModelInews: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentInewsDetailBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModelInews

        return binding.root
    }

}
package com.example.uas_pemograman_mobile.ui.update_covid19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.uas_pemograman_mobile.databinding.FragmentUpdateDetailBinding

class UpdateDataDetailFragment: Fragment() {
    private val viewModelUpdate: UpdateDataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateDetailBinding
            .inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModelUpdate

        return binding.root
    }
}
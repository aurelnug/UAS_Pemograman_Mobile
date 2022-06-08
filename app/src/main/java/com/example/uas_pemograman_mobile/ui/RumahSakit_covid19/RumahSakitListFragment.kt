package com.example.uas_pemograman_mobile.ui.RumahSakit_covid19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.uas_pemograman_mobile.R
import com.example.uas_pemograman_mobile.databinding.FragmentRsListBinding
import com.example.uas_pemograman_mobile.ui.Inews.InewsListAdapter
import com.example.uas_pemograman_mobile.ui.Inews.InewsListener
import com.example.uas_pemograman_mobile.ui.Inews.InewsViewModel
import com.example.uas_pemograman_mobile.ui.MyViewModel

class RumahSakitListFragment: Fragment() {
    private val viewModelrs: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRsListBinding.inflate(inflater)
        viewModelrs.getRumahSakit()
        binding.lifecycleOwner = this
        binding.viewModel = viewModelrs
        binding.recyclerView.adapter = RumahSakitListAdapter(RumahSakitListener { rs ->
            viewModelrs.onRumahSakitClicked(rs)
            findNavController()
                .navigate(R.id.action_nav_rsListFragment_to_rsDetailFragment)
        })
        (activity as AppCompatActivity).supportActionBar?.title = "Daftar Rumah Sakit Rujuan Covid 19"

        return binding.root
    }
}
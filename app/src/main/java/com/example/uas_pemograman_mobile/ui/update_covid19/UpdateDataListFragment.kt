package com.example.uas_pemograman_mobile.ui.update_covid19

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
import com.example.uas_pemograman_mobile.databinding.FragmentUpdateListBinding
import com.example.uas_pemograman_mobile.ui.RumahSakit_covid19.RumahSakitListAdapter
import com.example.uas_pemograman_mobile.ui.RumahSakit_covid19.RumahSakitListener

class UpdateDataListFragment: Fragment() {
    private val viewModelUpdate: UpdateDataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateListBinding.inflate(inflater)
        viewModelUpdate.getUpdateData()
        binding.lifecycleOwner = this
        binding.viewModel = viewModelUpdate
        binding.recyclerView.adapter = UpdateDataListAdapter(UpdateDataListener { update ->
            viewModelUpdate.onUpdateDataClicked(update)
            findNavController()
                .navigate(R.id.action_nav_updateListFragment_to_updateDetailFragment)
        })
        (activity as AppCompatActivity).supportActionBar?.title = "Update Data Covid 19"

        return binding.root
    }
}
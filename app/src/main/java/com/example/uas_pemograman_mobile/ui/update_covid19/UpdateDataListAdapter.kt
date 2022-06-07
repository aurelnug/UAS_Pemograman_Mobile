package com.example.uas_pemograman_mobile.ui.update_covid19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pemograman_mobile.R
import com.example.uas_pemograman_mobile.databinding.ListViewItemInewsBinding
import com.example.uas_pemograman_mobile.databinding.ListViewItemUpdateBinding
import com.example.uas_pemograman_mobile.network.InewsItem
import com.example.uas_pemograman_mobile.network.UpdateDataItem
import com.example.uas_pemograman_mobile.ui.Inews.InewsListAdapter
import com.example.uas_pemograman_mobile.ui.Inews.InewsListener
import com.example.uas_pemograman_mobile.ui.Inews.InewsViewModel

class UpdateDataListAdapter (val clickListener: UpdateDataListener) :
        ListAdapter<UpdateDataItem, UpdateDataListAdapter.UpdateDataViewHolder> (DiffCallback) {

    class UpdateDataViewHolder(
        var binding: ListViewItemUpdateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: UpdateDataListener, update: UpdateDataItem) {
            binding.update = update
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<UpdateDataItem>() {
        override fun areItemsTheSame(oldItem: UpdateDataItem, newItem: UpdateDataItem): Boolean {
            return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(oldItem: UpdateDataItem, newItem: UpdateDataItem): Boolean {
            return oldItem.jumlah_kasus == newItem.jumlah_kasus
                    && oldItem.jumlah_sembuh == newItem.jumlah_sembuh
                    && oldItem.jumlah_meninggal == newItem.jumlah_meninggal
                    && oldItem.jumlah_dirawat == newItem.jumlah_dirawat

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdateDataListAdapter.UpdateDataViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UpdateDataListAdapter.UpdateDataViewHolder(
            ListViewItemUpdateBinding.inflate(layoutInflater, parent, false)
        )
    }
    override fun onBindViewHolder(holder: UpdateDataListAdapter.UpdateDataViewHolder, position: Int) {
        val update = getItem(position)
        holder.bind(clickListener, update)
    }
}

class UpdateDataListener(val clickListener: (update: UpdateDataItem) -> Unit) {
    fun onClick(update: UpdateDataItem) = clickListener(update)
}
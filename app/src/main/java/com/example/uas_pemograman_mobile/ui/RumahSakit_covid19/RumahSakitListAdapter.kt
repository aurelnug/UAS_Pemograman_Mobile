package com.example.uas_pemograman_mobile.ui.RumahSakit_covid19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pemograman_mobile.databinding.ListViewItemRsBinding
import com.example.uas_pemograman_mobile.network.RumahSakit

class RumahSakitListAdapter ( val clickListener: RumahSakitListener) :
    ListAdapter<RumahSakit, RumahSakitListAdapter.RumahSakitViewHolder>(DiffCallback) {

    class RumahSakitViewHolder(
        var binding: ListViewItemRsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: RumahSakitListener, rs: RumahSakit) {
            binding.rs = rs
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<RumahSakit>() {
        override fun areItemsTheSame(oldItem: RumahSakit, newItem: RumahSakit): Boolean {
            return oldItem.nama == newItem.nama
        }

        override fun areContentsTheSame(oldItem: RumahSakit, newItem: RumahSakit): Boolean {
            return oldItem.kode_rs == newItem.kode_rs
                    && oldItem.tempat_tidur == newItem.tempat_tidur
                    && oldItem.telepon == newItem.telepon
                    && oldItem.alamat == newItem.alamat
                    && oldItem.tipe == newItem.tipe
                    && oldItem.wilayah == newItem.wilayah
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RumahSakitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RumahSakitViewHolder(
            ListViewItemRsBinding.inflate(layoutInflater, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RumahSakitViewHolder, position: Int) {
        val morty = getItem(position)
        holder.bind(clickListener, morty)
    }
}

class RumahSakitListener(val clickListener: (rs: RumahSakit) -> Unit) {
    fun onClick(rs: RumahSakit) = clickListener(rs)
}
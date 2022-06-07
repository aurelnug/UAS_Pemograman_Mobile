package com.example.uas_pemograman_mobile.ui.Inews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pemograman_mobile.databinding.ListViewItemInewsBinding
import com.example.uas_pemograman_mobile.network.InewsItem

class InewsListAdapter (val clickListener: InewsListener) :
    ListAdapter<InewsItem, InewsListAdapter.InewsViewHolder> (DiffCallback) {

        class InewsViewHolder(
            var binding: ListViewItemInewsBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(clickListener: InewsListener, inews: InewsItem) {
                binding.inews = inews
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }
    companion object DiffCallback: DiffUtil.ItemCallback<InewsItem>() {
        override fun areItemsTheSame(oldItem: InewsItem, newItem: InewsItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: InewsItem, newItem: InewsItem): Boolean {
            return oldItem.author == newItem.author
                    && oldItem.description == newItem.description
                    && oldItem.urlToImage == newItem.urlToImage
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return InewsViewHolder(
            ListViewItemInewsBinding.inflate(layoutInflater, parent, false)
        )
    }
    override fun onBindViewHolder(holder: InewsViewHolder, position: Int) {
        val inews = getItem(position)
        holder.bind(clickListener, inews)
    }
}

class InewsListener(val clickListener: (inews: InewsItem) -> Unit) {
    fun onClick(inews: InewsItem) = clickListener(inews)
}
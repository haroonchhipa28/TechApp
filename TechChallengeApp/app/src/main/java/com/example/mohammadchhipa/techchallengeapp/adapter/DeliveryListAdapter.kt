package com.example.mohammadchhipa.techchallengeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mohammadchhipa.techchallengeapp.databinding.ListItemBinding
import com.example.mohammadchhipa.techchallengeapp.listener.ItemClickListener
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData

const val VIEW_TYPE_ITEM = 0
const val VIEW_TYPE_LOADING = 1

class DeliveryListAdapter(private var itemClickListener: ItemClickListener) : ListAdapter<DeliveryData, RecyclerView.ViewHolder>(DATA_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context)
                , parent, false)
        binding.callback = itemClickListener
        return ItemHolder(binding)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(getItem(position) as DeliveryData)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount())
            VIEW_TYPE_ITEM
        else VIEW_TYPE_LOADING

    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    class ItemHolder(private val binding: ListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
        lateinit var deliveryData: DeliveryData

        fun bind(deliveryData: DeliveryData) {
            binding.deliveryData = deliveryData
            this.deliveryData = deliveryData
        }
    }

    companion object {
        val DATA_COMPARATOR = object : DiffUtil.ItemCallback<DeliveryData>() {
            override fun areItemsTheSame(oldItem: DeliveryData, newItem: DeliveryData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DeliveryData, newItem: DeliveryData): Boolean {
                return oldItem == newItem
            }
        }
    }
}
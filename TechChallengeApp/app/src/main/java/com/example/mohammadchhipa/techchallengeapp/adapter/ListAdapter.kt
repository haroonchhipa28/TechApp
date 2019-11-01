package com.example.mohammadchhipa.techchallengeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mohammadchhipa.techchallengeapp.R
import com.example.mohammadchhipa.techchallengeapp.databinding.ListItemBinding
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData


class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private lateinit var listData: List<DeliveryData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::listData.isInitialized) listData.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    fun updatePostList(data: List<DeliveryData>) {
        this.listData = data
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DeliveryData) {
            binding.deliveryData = data
        }
    }
}
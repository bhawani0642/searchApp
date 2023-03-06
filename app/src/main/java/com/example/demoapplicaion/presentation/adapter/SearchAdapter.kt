package com.example.demoapplicaion.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplicaion.data.model.Lf
import com.example.demoapplicaion.databinding.ItemSearchBinding

class SearchAdapter:RecyclerView.Adapter<SearchAdapter.SearchViewHolder>()  {

    private val callback = object : DiffUtil.ItemCallback<Lf>(){
        override fun areItemsTheSame(oldItem: Lf, newItem: Lf): Boolean {
            return oldItem.lf == newItem.lf
        }

        override fun areContentsTheSame(oldItem: Lf, newItem: Lf): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)



    inner class SearchViewHolder(var binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(longForm: Lf){
            binding.searchItem = longForm
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        var longForm = differ.currentList[position]
        holder.bind(longForm)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}
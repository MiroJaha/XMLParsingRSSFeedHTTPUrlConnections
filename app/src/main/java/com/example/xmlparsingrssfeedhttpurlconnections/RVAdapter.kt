package com.example.xmlparsingrssfeedhttpurlconnections

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlparsingrssfeedhttpurlconnections.databinding.ItemViewBinding

class RVAdapter (private val informationList: ArrayList<Group>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    private lateinit var myListener: OnItemClickListener

    class ItemViewHolder(val binding: ItemViewBinding, listener: OnItemClickListener ): RecyclerView.ViewHolder(binding.root){

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener:OnItemClickListener ){
        myListener=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false),myListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val title = informationList[position].title
        val name = informationList[position].name

        holder.binding.apply {
            titleTV.text = "Title: $title"
            nameTV.text = "By: $name"
        }
    }

    override fun getItemCount() = informationList.size

}
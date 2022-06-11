package com.dev.androidapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item.view.*

class ItemAdapter(var items : List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.view.textViewTitle.text = item.title
        holder.view.textViewMetricType.text = item.metricType
        holder.view.textViewValue.text = item.value.toString()
    }

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view)

//    private fun setFilteredList(filteredList: List<Item>) {
//        this.items = filteredList
//        notifyDataSetChanged()
//    }

}
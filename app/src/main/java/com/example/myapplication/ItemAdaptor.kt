/*package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdaptor(private var mList:ArrayList<String>): RecyclerView.Adapter<ItemAdaptor.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = mList[position]
        holder.item.text = item
    }
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val item: TextView = ItemView.findViewById(R.id.tvItem)


    }
}*/
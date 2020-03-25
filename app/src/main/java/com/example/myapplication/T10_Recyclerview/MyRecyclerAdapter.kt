package com.example.myapplication.T10_Recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MyRecyclerAdapter(val myList:ArrayList<T10_Recyclerview.MyData>) : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custom_listview, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = myList[position]
        holder.bind(data)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle:TextView = itemView.findViewById(R.id.tvTitle)
        val tvDesc:TextView = itemView.findViewById(R.id.tvDesc)
        val itemImageView:ImageView = itemView.findViewById(R.id.itemImageView)

        fun bind(data:T10_Recyclerview.MyData) {
            tvTitle.text = data.title
            tvDesc.text = data.desc
            itemImageView.setImageResource(data.img)
        }

    }


}
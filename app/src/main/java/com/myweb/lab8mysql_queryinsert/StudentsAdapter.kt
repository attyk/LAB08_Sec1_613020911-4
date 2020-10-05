package com.myweb.lab8mysql_queryinsert

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter (val item : List<Student>, val context: Context):RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view_item = LayoutInflater.from(parent.context).inflate(R.layout.std_item_layout,parent, false)
        return ViewHolder(view_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.tvID.text ="ID: " +item[position].std_id
        holder.tvName.text = item[position].std_name
        holder.tvAge.text ="Age: "+ item[position].std_age.toString()
    }

    override fun getItemCount(): Int {
        return item.size
    }
}
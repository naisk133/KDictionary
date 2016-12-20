package com.sk.nai.kdictionary.activity.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sk.nai.kdictionary.R
import com.sk.nai.kdictionary.model.Person

/**
 * Created by naisk133 on 20/12/2559.
 */
class MyRecyclerAdapter(val list: List<Person>) : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameText: TextView = itemView.findViewById(R.id.text_name) as TextView
        var lastNameText: TextView = itemView.findViewById(R.id.text_last_name) as TextView
    }

    override fun getItemCount(): Int {
        Log.wtf("MyRecyclerAdapter", "" + list.size)
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        Log.wtf("MyRecyclerAdapter", "create ViewHolder")
        return MyViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        Log.wtf("MyRecyclerAdapter", "binding at position $position -> name = ${list[position].name}")
        holder?.nameText?.text = list[position].name
        holder?.lastNameText?.text = list[position].lastName
    }
}
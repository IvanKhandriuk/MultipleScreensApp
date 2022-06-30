package com.ikhandriuk.multiplescreensapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ikhandriuk.multiplescreensapp.Model.Parameters.DataItem
import com.ikhandriuk.multiplescreensapp.Model.Parameters.ParamItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import com.ikhandriuk.multiplescreensapp.R

class FirstAdapter: RecyclerView.Adapter<FirstAdapter.MyViewHolder>(){

    private var myList= emptyList<ParamItem>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_parametrs_layout, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FirstAdapter.MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_power).text=myList[position].bdata.toString()
        holder.itemView.findViewById<TextView>(R.id.item_forecast).text=myList[position].ddata.toString()
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<ParamItem>){
        myList= newList
        notifyDataSetChanged()
    }
}
package com.ikhandriuk.multiplescreensapp.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ikhandriuk.multiplescreensapp.Model.ParamItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import com.ikhandriuk.multiplescreensapp.R

class FirstAdapter: RecyclerView.Adapter<FirstAdapter.FirstViewHolder>(){

    private var startList= emptyList<ParamItem>()

     class FirstViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        return FirstViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_parametrs_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return startList.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int){

        holder.itemView.findViewById<TextView>(R.id.item_power).text=startList[position].ddata.toString()
        holder.itemView.findViewById<TextView>(R.id.item_forecast).text=startList[position].bdata.toString()
    }

    fun setData(newList: List<ParamItem>){
        startList=newList
        notifyDataSetChanged()
    }
}
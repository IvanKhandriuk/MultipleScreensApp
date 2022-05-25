package com.ikhandriuk.multiplescreensapp.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import com.ikhandriuk.multiplescreensapp.R
import com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.MainViewModel

class FirstAdapter: RecyclerView.Adapter<FirstAdapter.FirstViewHolder>(){


    private lateinit var power:TextView
    private lateinit var forecast:TextView
    private lateinit var deviation:TextView


    private var startList= emptyList<ParametersItem>()

     class FirstViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        return FirstViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_parametrs_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return startList.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int){
        power.findViewById<TextView>(R.id.item_power)
        forecast.findViewById<TextView>(R.id.item_forecast)
        deviation.findViewById<TextView>(R.id.item_deviation)

        power.text=startList[position].data.toString()
    }

    fun setData(newList: List<ParametersItem>){
        startList=newList
        notifyDataSetChanged()
    }
}
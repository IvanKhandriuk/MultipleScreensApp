package com.ikhandriuk.multiplescreensapp.Model

import org.json.JSONArray

data class ParametersItem(val data: List<DataItem>?)

data class DataItem(val param: List<ParamItem>?,
                    val name: String = "",
                    val id: Int = 0)

data class ParamItem(val ddata: List<JSONArray>?,
                     val bdata: List<JSONArray>?)









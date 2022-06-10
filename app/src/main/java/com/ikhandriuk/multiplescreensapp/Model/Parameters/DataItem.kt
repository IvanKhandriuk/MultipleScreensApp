package com.ikhandriuk.multiplescreensapp.Model.Parameters

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray

data class DataItem(
    val param: List<ParamItem>?,
    val name: String = "",
    val id: Int = 0)

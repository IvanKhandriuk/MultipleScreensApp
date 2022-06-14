package com.ikhandriuk.multiplescreensapp.Model.Parameters

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONObject

data class ParamItem(
    val ddata: List<JsonArray>?,
    val bdata: List<JsonArray>?,
    val d_id: Int=0)

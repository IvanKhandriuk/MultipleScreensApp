package com.ikhandriuk.multiplescreensapp.Model.TestParameters

import com.ikhandriuk.multiplescreensapp.Model.Parameters.ParamItem
import org.json.JSONArray

data class TestParametersItems(
    val msg: String = "",
    val status: Int = 0,
    val param: List<ParamItem>?,
    val name: String = "",
    val id: Int = 0,
    val ddata: List<JSONArray>?,
    val bdata: List<JSONArray>?
)

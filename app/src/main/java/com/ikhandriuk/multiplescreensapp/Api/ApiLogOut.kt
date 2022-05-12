package com.ikhandriuk.multiplescreensapp.Api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiLogOut {

    @GET("http://e-meter.biz/deauth")
    suspend fun goLogOut(@Query("code") outCode:String)
}
package com.ikhandriuk.multiplescreensapp.Api

import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiLogOut {

    @GET("deauth")
    suspend fun logOut(@Query("code") code:String): Response<LogOutItem>
}
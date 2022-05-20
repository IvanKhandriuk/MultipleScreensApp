package com.ikhandriuk.multiplescreensapp.Api

import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiLogOut {

    @GET("ev_auth")
    suspend fun logOut(@Query("deauth") code:String):Response<LogOutItem>

    @GET
    fun getStringResponse(@Url url: String?): Call<String?>?
}


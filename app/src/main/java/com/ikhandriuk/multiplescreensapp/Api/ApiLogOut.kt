package com.ikhandriuk.multiplescreensapp.Api

import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiLogOut {

    @GET("deayth")
    suspend fun logOut(@Query("code") code:String):Response<LogOutItem>
}


package com.examples.getrequestapp.Data.Api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*


//ev_auth.php?login=login&pass=base64(pass)
interface EmeterApi {

    @GET("ev_auth.php")
    suspend fun setAuthorization(
        @Query("login") login: String,
        @Query("pass") pass: String
    ): Response<AuthorizationItem>

    @GET("ev_auth")
    suspend fun logOut(@Query("deauth") code: String): Response<LogOutItem>

    @GET("deviation.asdlf?")
    fun getData(
        @Query("code") code: String,
        @Query("notlast") notlast: String,
        @Query("action") action: String,
        @Query("date") date: String,
        @Query("ids") ids: String,
        @Query("time") time: String,
    ): Call<List<ParametersItem>>

    //https://ev.e-meter.biz/deviation.
    // asdlf?
    // code=1454366173&notlast=1&action=data&date=2022-05-23&ids=41&time=1653288441658
}
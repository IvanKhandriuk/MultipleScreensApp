package com.examples.getrequestapp.Data.Api

import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import retrofit2.Response
import retrofit2.http.*


//ev_auth.php?login=login&pass=base64(pass)
interface ApiAuthorization {
    @GET("ev_auth.php")
    suspend fun setAuthorization (
        @Query("login")login: String,
        @Query("pass")pass: String):Response <AuthorizationItem>

    //https://ev.e-meter.biz/deviation.asdlf?code=1454366173&notlast=1&action=data&date=2022-05-23&ids=41&time=1653288441658

    @GET("deviation.asdlf?")
    suspend fun getData(
        @Query("code")code:String,
        @Query("notlast")notlast:String,
        @Query("action")action:String,
        @Query("date")date:String,
        @Query("ids")ids:String,
        @Query("time")time:String,
    ): List<ParametersItem>
}
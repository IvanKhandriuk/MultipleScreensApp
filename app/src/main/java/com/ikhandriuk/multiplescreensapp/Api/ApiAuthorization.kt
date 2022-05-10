package com.examples.getrequestapp.Data.Api

import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import retrofit2.Response
import retrofit2.http.*


//ev_auth.php?login=login&pass=base64(pass)
interface ApiAuthorization {
    @GET("ev_auth.php")
    suspend fun setAuthorization (
        @Query("login")login: String,
        @Query("pass")pass: String):Response <AuthorizationItem>
}
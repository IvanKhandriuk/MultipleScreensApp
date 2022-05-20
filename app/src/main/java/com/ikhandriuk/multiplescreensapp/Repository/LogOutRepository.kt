package com.ikhandriuk.multiplescreensapp.Repository

import com.ikhandriuk.multiplescreensapp.Api.RetrofitLogOut
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import okhttp3.Headers
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Header

class LogOutRepository {
    suspend fun logOut(authorizationCode:String): Response<LogOutItem>{
        return RetrofitLogOut.API.logOut(authorizationCode)
    }

    suspend fun getStringResponse (authorizationCode: String) {
    }
}
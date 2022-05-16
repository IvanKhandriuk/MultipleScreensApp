package com.ikhandriuk.multiplescreensapp.Repository

import com.ikhandriuk.multiplescreensapp.Api.RetrofitLogOut
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import retrofit2.Response

class LogOutRepository {
    suspend fun logOut(authorizationCode:String): Response<LogOutItem> {
        return RetrofitLogOut.API.logOut(authorizationCode)
    }
}
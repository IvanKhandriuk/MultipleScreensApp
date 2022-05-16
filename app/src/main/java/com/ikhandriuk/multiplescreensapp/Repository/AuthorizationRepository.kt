package com.ikhandriuk.multiplescreensapp.Repository

import com.examples.getrequestapp.Data.Api.RetrofitInstance
import com.ikhandriuk.multiplescreensapp.Api.RetrofitLogOut
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import retrofit2.Response

class AuthorizationRepository {

    suspend fun setAuthorization(login: String,pass: String):Response<AuthorizationItem>{
        return RetrofitInstance.API.setAuthorization(login, pass)
    }
}
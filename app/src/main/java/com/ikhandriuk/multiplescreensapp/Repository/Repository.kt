package com.ikhandriuk.multiplescreensapp.Repository

import com.examples.getrequestapp.Data.Api.RetrofitInstance
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Model.ParamItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import retrofit2.Response

class Repository {

    suspend fun setAuthorization(login: String, pass: String): Response<AuthorizationItem> {
        return RetrofitInstance.API.setAuthorization(login, pass)
    }

    suspend fun logOut(authorizationCode: String): Response<LogOutItem> {
        return RetrofitInstance.API.logOut(authorizationCode)
    }

    suspend fun getDAta(
        code: String,
        notlast: String,
        action: String,
        date: String,
        ids: String,
        time: String
    ): Response<List<ParamItem>> {
        return RetrofitInstance.API.getData(code, notlast, action, date, ids, time)
    }
}
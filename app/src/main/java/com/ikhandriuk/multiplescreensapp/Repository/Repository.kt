package com.ikhandriuk.multiplescreensapp.Repository

import com.examples.getrequestapp.Data.Api.RetrofitInstance
import com.ikhandriuk.multiplescreensapp.Api.RetrofitDataInstance
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Model.Parameters.ParamItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import retrofit2.Response

class Repository {

    suspend fun setAuthorization(login: String, pass: String): Response<AuthorizationItem> {
        return RetrofitInstance.API.setAuthorization(login, pass)
    }

    suspend fun logOut(authorizationCode: String): Response<LogOutItem> {
        return RetrofitInstance.API.logOut(authorizationCode)
    }

    suspend fun getData(
        code: String,
        notlast: String,
        action: String,
        date: String,
        ids: String,
        time: String
    ): Response<List<ParametersItem>> {
        return RetrofitDataInstance.APIData.getData(code, notlast, action, date, ids, time)
    }
}
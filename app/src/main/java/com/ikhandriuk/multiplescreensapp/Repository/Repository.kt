package com.ikhandriuk.multiplescreensapp.Repository

import com.examples.getrequestapp.Data.Api.RetrofitInstance
import com.google.gson.GsonBuilder
import com.ikhandriuk.multiplescreensapp.Api.RetrofitDataInstance
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import retrofit2.Call
import retrofit2.Response
import java.util.*


class Repository {

    suspend fun setAuthorization(login: String, pass: String): Response<AuthorizationItem> {
        return RetrofitInstance.API.setAuthorization(login, pass)
    }

    suspend fun logOut(authorizationCode: String): Response<LogOutItem> {
        return RetrofitInstance.API.logOut(authorizationCode)
    }
//    var gson = GsonBuilder()
//        .setLenient()
//        .create()
//    suspend fun getData(
//        code: String,
//        notlast: String,
//        action: String,
//        date: String,
//        ids: String,
//        time: String
//    ): Call<List<ParametersItem>>  {
//        return RetrofitDataInstance.APIData.getData(code, notlast, action, date, ids, time)
//    }

}
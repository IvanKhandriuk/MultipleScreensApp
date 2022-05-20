package com.ikhandriuk.multiplescreensapp.Api

import com.examples.getrequestapp.Data.Api.ApiAuthorization
import com.ikhandriuk.multiplescreensapp.Util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Headers

object RetrofitLogOut {

    private val retrofitOut by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.LOG_OUT_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
    val API: ApiLogOut by lazy{
        retrofitOut.create(ApiLogOut::class.java)
    }
}
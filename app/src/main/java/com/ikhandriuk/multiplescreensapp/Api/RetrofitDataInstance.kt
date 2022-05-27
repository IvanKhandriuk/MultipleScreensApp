package com.ikhandriuk.multiplescreensapp.Api

import com.examples.getrequestapp.Data.Api.EmeterApi
import com.ikhandriuk.multiplescreensapp.Util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDataInstance {
    private val retrofitData by lazy{
        Retrofit.Builder()
            .baseUrl(Constants.DATA_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val APIData: EmeterApi by lazy{
        retrofitData.create(EmeterApi::class.java)
    }
}
package com.examples.getrequestapp.Data.Api

import com.ikhandriuk.multiplescreensapp.Util.Constants.Companion.BASE_URL
import com.ikhandriuk.multiplescreensapp.Util.Constants.Companion.DATA_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API:EmeterApi by lazy{
        retrofit.create(EmeterApi::class.java)
    }
}
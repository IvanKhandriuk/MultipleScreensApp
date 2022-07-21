package com.examples.getrequestapp.Data.Api

import com.ikhandriuk.multiplescreensapp.Util.Constants
import com.ikhandriuk.multiplescreensapp.Util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


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
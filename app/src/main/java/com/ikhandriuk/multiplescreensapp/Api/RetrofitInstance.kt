package com.examples.getrequestapp.Data.Api

import com.ikhandriuk.multiplescreensapp.Util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitInstance {

    private val httplClient by lazy{
        OkHttpClient.Builder()
            .callTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httplClient)
            .build()
    }


    val API:EmeterApi by lazy{
        retrofit.create(EmeterApi::class.java)
    }
}
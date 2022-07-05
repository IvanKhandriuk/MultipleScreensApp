package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.examples.getrequestapp.Data.Api.EmeterApi
import com.google.gson.JsonArray
import com.ikhandriuk.multiplescreensapp.Model.Parameters.DataItem
import com.ikhandriuk.multiplescreensapp.Model.Parameters.ParamItem
import com.ikhandriuk.multiplescreensapp.Model.ParametersItem
import com.ikhandriuk.multiplescreensapp.R
import com.ikhandriuk.multiplescreensapp.Repository.Repository
import com.ikhandriuk.multiplescreensapp.Screens.LogIn.LogIn
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModel
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModelFactory
import com.ikhandriuk.multiplescreensapp.Util.Constants.Companion.DATA_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*


class FirstScreen : AppCompatActivity() {

//    private lateinit var recyclerView: RecyclerView
//    private val firstAdapter by lazy { FirstAdapter() }

    private lateinit var viewModel: MainViewModel
    private val date = SimpleDateFormat("yyyy-MM-dd")
    val calendar = Calendar.getInstance()
    val currentDate = date.format(calendar.time)
    val nanotime = calendar.timeInMillis.toString()

    //add custom image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val authCode = intent.getStringExtra("RsCode").toString()
        getMyData()
    }

    private fun getMyData() {
        val authCode = intent.getStringExtra("RsCode").toString()
        val retrofitBuilder=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(DATA_URL)
            .build()
            .create(EmeterApi::class.java)

        val retrofitData=retrofitBuilder.getData(authCode,
            "1",
            "data",
            currentDate,
            "",
            nanotime)

        retrofitData.enqueue(object : Callback<ParametersItem?> {
            override fun onResponse(
                call: Call<ParametersItem?>,
                response: Response<ParametersItem?>
            ) {
                val responseBody = nameFromData( response.body()?.data).toString()
                Log.d("CurrentBody", responseBody)
            }

            override fun onFailure(call: Call<ParametersItem?>, t: Throwable) {
                Log.d("CurrentError","onFailure: "+t.message)
            }
        })

    }

    private fun nameFromData(data: List<DataItem>?): List<String> {
        var name:MutableList<String> = arrayListOf()
        if (data != null)
            for( i in data) {
                name.add(i.name)
            }
        return name
    }

    private fun idFromData(data: List<DataItem>?): List<Int> {
        var id:MutableList<Int> = arrayListOf()
        if (data != null)
            for( i in data) {
                id.add(i.id)
            }
        return id
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val authCode = intent.getStringExtra("RsCode").toString()
        val repository = Repository()
        val secondViewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, secondViewModelFactory)[MainViewModel::class.java]
        Log.d("RsCode", authCode)

        if (item.itemId == R.id.logout) {

            viewModel.logOut(authCode)
            viewModel.logOutResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    Log.d("Answer_code", response.code().toString())
                } else {
                    Log.d("Answer_error", response.errorBody().toString())
                }
            })
            finish()
            val intent = Intent(this@FirstScreen, LogIn::class.java)
            startActivity(intent)
            return true
        }
        return true
    }


}
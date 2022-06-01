package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikhandriuk.multiplescreensapp.Adapters.FirstAdapter
import com.ikhandriuk.multiplescreensapp.R
import com.ikhandriuk.multiplescreensapp.Repository.Repository
import com.ikhandriuk.multiplescreensapp.Screens.LogIn.LogIn
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModel
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class FirstScreen : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val firstAdapter by lazy { FirstAdapter() }
    private val date = SimpleDateFormat("yyyy-MM-dd")
    val calendar = Calendar.getInstance()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.item_parametrs_layout)

       //setupRecyclerview()

        val authCode = intent.getStringExtra("RsCode").toString()
        val currentDate = date.format(calendar.time)
        val nanotime = calendar.timeInMillis.toString()

        Log.d("CurrentDate", currentDate)
        Log.d("CurrentTime", nanotime)
        Log.d("CurrentAuthCode", authCode)
        // code=1454366173&notlast=1&action=data&date=2022-05-23&ids=41&time=1653288441658

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getData(
            authCode,
            "1",
            "data",
            currentDate,
            "41",
            nanotime
        )
        viewModel.myDataResponse.observe(this, Observer { response->
            if(response.isSuccessful){
                Log.d("DataResponse",response.code().toString())
                //response.body()?.let { firstAdapter.setData(it) }
            }else{
                Toast.makeText(this,response.code(),Toast.LENGTH_SHORT).show()
            }
        })

    }

//    private fun setupRecyclerview(){
//        //recyclerView=findViewById(R.id.mainRecyclerView)
//        recyclerView.adapter=firstAdapter
//        recyclerView.layoutManager=LinearLayoutManager(this)
//    }


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
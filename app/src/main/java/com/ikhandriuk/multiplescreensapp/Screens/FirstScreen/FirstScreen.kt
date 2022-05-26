package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.R
import com.ikhandriuk.multiplescreensapp.Repository.Repository
import com.ikhandriuk.multiplescreensapp.Screens.LogIn.LogIn
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModel
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModelFactory
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class FirstScreen : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val currentDate = SimpleDateFormat("yyyy-MM-dd")
    @RequiresApi(Build.VERSION_CODES.O)
    private val currentDate2 = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val currentTime =SimpleDateFormat("SS").toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // code=1454366173&notlast=1&action=data&date=2022-05-23&ids=41&time=1653288441658

        val date=Date()
        val cal=Calendar.getInstance()
        val now = LocalDateTime.now()


        Log.d("CurrentDate1", currentDate.format(date))
        Log.d("CurrentDate2", currentDate.format(cal.time))
        Log.d("CurrentDate3", currentDate2.format(now))
        Log.d("CurrentDate4", DateTimeFormatter.ofPattern(""))

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
//        firstViewModel.getData(
//            "$authCode",
//            "1",
//            "data",
//            "$currentDate",
//            "41",
//            "")

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
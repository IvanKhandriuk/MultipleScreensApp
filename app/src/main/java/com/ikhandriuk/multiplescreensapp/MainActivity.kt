package com.ikhandriuk.multiplescreensapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.Repository.AuthorizationRepository

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var getData: LogIn
    private lateinit var txtResponse:TextView
    private lateinit var btnGetCode:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        txtResponse=findViewById<TextView>(R.id.txtResponse)
        val authorizationRepository = AuthorizationRepository()
        val viewModelFactory=MainViewModelFactory(authorizationRepository)

        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        val responseCode =viewModel.myResponse.value?.body()?.code




        btnGetCode.setOnClickListener {
            viewModel.myResponse.observe(this, androidx.lifecycle.Observer { response ->
                if (response.isSuccessful) {
                    txtResponse.text = getData.viewModel.myResponse.value?.body()?.code.toString()
                    Log.d("ResponseMain code", txtResponse.toString())
                } else {
                    Log.d("Error", response.code().toString())
                }
            })
        }

        if(item.itemId==R.id.logout){
            //signout
            finish()
            val intent=Intent(this@MainActivity, LogIn::class.java)
            startActivity(intent)
            return true
        }
        return true
    }
}
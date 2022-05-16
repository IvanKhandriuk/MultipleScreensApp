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

    private lateinit var viewModel:SecondViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val authCode=intent.getStringExtra("RsCode")
            Log.d("Response_code: ", authCode.toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.logout){
            val authCode=intent.getStringExtra("RsCode")
            viewModel.logOut(authCode.toString())
            val outCode=viewModel.logOutResponse.value?.body()?.logOutCode
            Log.d("Response code", outCode.toString())
            finish()
            val intent=Intent(this@MainActivity, LogIn::class.java)
            startActivity(intent)
            return true
        }
        return true
    }
}
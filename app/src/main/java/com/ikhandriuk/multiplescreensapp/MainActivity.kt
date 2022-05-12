package com.ikhandriuk.multiplescreensapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.Repository.AuthorizationRepository

private lateinit var viewModel: MainViewModel
private lateinit var txtView:TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val txtView=findViewById<TextView>(R.id.txtView)
        val authorizationRepository = AuthorizationRepository()
        val viewModelFactory=MainViewModelFactory(authorizationRepository)

        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        viewModel.myResponse.observe(this, androidx.lifecycle.Observer{ response ->
            if (response.isSuccessful) {
                txtView.text=response.body()?.code.toString()
            } else {
                Log.d("Error",response.code().toString())
            }
        })

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
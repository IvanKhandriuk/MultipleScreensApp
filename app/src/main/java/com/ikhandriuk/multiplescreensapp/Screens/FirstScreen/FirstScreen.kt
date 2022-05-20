package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.R
import com.ikhandriuk.multiplescreensapp.Repository.LogOutRepository
import com.ikhandriuk.multiplescreensapp.Screens.LogIn.LogIn
import com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.LogOut.SecondViewModel
import com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.LogOut.SecondViewModelFactory

class FirstScreen : AppCompatActivity() {

    private lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val authCode = intent.getStringExtra("RsCode")
        val repository=LogOutRepository()
        val secondViewModelFactory=SecondViewModelFactory(repository)
        viewModel= ViewModelProvider(this,secondViewModelFactory).get(SecondViewModel::class.java)
        Log.d("RsCode",authCode.toString())
        if (item.itemId == R.id.logout) {
            viewModel.logOut(authCode.toString())
            viewModel.logOutResponse.observe(this,Observer{response->
                if(response.isSuccessful){
                    Log.d("Answer_code",response.code().toString())
                }
                else{
                    Log.d("Answer_error",response.errorBody().toString())
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
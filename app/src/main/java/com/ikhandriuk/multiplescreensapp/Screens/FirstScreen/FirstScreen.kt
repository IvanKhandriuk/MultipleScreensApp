package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ikhandriuk.multiplescreensapp.R
import com.ikhandriuk.multiplescreensapp.Screens.LogIn.LogIn
import com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.LogOut.SecondViewModel

class FirstScreen : AppCompatActivity() {

    private lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val authCode = intent.getStringExtra("RsCode")
        Log.d("Response_code: ", authCode.toString())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            val authCode = intent.getStringExtra("RsCode")
            viewModel.logOut(authCode.toString())
            Log.d("Response_from_logOut", viewModel.logOutResponse.value?.code().toString())
            finish()
            val intent = Intent(this@FirstScreen, LogIn::class.java)
            startActivity(intent)
            return true
        }
        return true
    }
}
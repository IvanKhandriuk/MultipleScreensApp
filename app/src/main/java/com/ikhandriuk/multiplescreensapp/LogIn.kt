package com.ikhandriuk.multiplescreensapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.Repository.AuthorizationRepository
import java.util.*

class LogIn : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var edtLogIn: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogIn: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()

        edtLogIn=findViewById(R.id.edtLogin)
        edtPassword=findViewById(R.id.edtPass)
        btnLogIn=findViewById(R.id.btnLogIn)


        val authorizationRepository = AuthorizationRepository()
        val viewModelFactory=MainViewModelFactory(authorizationRepository)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        btnLogIn.setOnClickListener {
            val myLogIn = edtLogIn.text.toString()
            val myPassWord = edtPassword.text.toString()
            Log.d("name", myLogIn)
            val encodePass: String = Base64.getEncoder().encodeToString(myPassWord.toByteArray())
            viewModel.setAuthorization(myLogIn, encodePass)


            viewModel.myResponse.observe(this, androidx.lifecycle.Observer{ response ->
                if (response.isSuccessful) {
                    Log.d("Response", response.body()?.code.toString())
                    Log.d("Response", response.body()?.result.toString())
                    val intent=Intent(this@LogIn,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Log.d("Error",response.code().toString())
                    Toast.makeText(this@LogIn,"Wrong password or login",Toast.LENGTH_SHORT).show()
                }
            })
        }
        }
    }
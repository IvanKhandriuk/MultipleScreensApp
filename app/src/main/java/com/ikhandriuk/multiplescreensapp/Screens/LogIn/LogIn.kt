package com.ikhandriuk.multiplescreensapp.Screens.LogIn

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModel
import com.ikhandriuk.multiplescreensapp.Screens.MainViewModelFactory
import com.ikhandriuk.multiplescreensapp.R
import com.ikhandriuk.multiplescreensapp.Repository.Repository
import com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.FirstScreen
import java.util.*

class LogIn : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
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


        val repository = Repository()
        val viewModelFactory= MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

        btnLogIn.setOnClickListener {

            val myLogIn = edtLogIn.text.toString()
            val myPassWord = edtPassword.text.toString()
            val encodePass: String = Base64.getEncoder().encodeToString(myPassWord.toByteArray())
            viewModel.setAuthorization(myLogIn, encodePass)
            viewModel.myAuthResponse.observe(this, androidx.lifecycle.Observer{ response ->
                if (response.isSuccessful) {
                    Log.d("RsCode", response.body()?.code.toString())
                    Log.d("Response result", response.body()?.result.toString())
                    val intent=Intent(this@LogIn, FirstScreen::class.java)
                    intent.putExtra("RsCode",viewModel.myAuthResponse.value?.body()?.code.toString())
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
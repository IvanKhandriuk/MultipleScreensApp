package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.LogOut

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Repository.LogOutRepository
import kotlinx.coroutines.launch
import okhttp3.Headers
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Header

class SecondViewModel(private val repositoryLogOut:LogOutRepository): ViewModel() {

    val logOutResponse: MutableLiveData<Response<LogOutItem>> = MutableLiveData()

    val falseLogOutResponse: MutableLiveData<Response<String>> = MutableLiveData()

    fun logOut(code: String) {
        viewModelScope.launch {
            val response = repositoryLogOut.logOut(code)
            logOutResponse.value = response
        }
    }
}
package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.LogOut

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel(private val repositoryLogOut:Repository): ViewModel() {

    val logOutResponse: MutableLiveData<Response<LogOutItem>> = MutableLiveData()

    val falseLogOutResponse: MutableLiveData<Response<String>> = MutableLiveData()

    fun logOut(code: String) {
        viewModelScope.launch {
            val response = repositoryLogOut.logOut(code)
            logOutResponse.value = response
        }
    }
}
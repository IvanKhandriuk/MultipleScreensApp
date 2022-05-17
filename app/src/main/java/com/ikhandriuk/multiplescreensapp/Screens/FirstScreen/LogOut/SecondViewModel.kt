package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.LogOut

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Repository.LogOutRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class SecondViewModel(private val repositoryLogOut:LogOutRepository): ViewModel() {

    val logOutResponse: MutableLiveData<Response<LogOutItem>> = MutableLiveData()

    fun logOut(authorizationCode: String){
        viewModelScope.launch {
            val response=repositoryLogOut.logOut(authorizationCode)
            logOutResponse.value=response
        }
    }
}
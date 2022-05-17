package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Repository.AuthorizationRepository
import com.ikhandriuk.multiplescreensapp.Repository.LogOutRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repositoryAuthorization: AuthorizationRepository): ViewModel() {

    val myResponse: MutableLiveData<Response<AuthorizationItem>> = MutableLiveData()

    fun setAuthorization(login:String,pass:String) {
        viewModelScope.launch {
            val response = repositoryAuthorization.setAuthorization(login, pass)
            myResponse.value = response
        }
    }

}
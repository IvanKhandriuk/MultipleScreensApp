package com.ikhandriuk.multiplescreensapp.Screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikhandriuk.multiplescreensapp.Model.AuthorizationItem
import com.ikhandriuk.multiplescreensapp.Model.LogOutItem
import com.ikhandriuk.multiplescreensapp.Model.ParamItem
import com.ikhandriuk.multiplescreensapp.Repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myAuthResponse: MutableLiveData<Response<AuthorizationItem>> = MutableLiveData()

    fun setAuthorization(login:String,pass:String) {
        viewModelScope.launch {
            val response = repository.setAuthorization(login, pass)
            myAuthResponse.value = response
        }
    }

    val myDataResponse: MutableLiveData<Response<List<ParamItem>>> = MutableLiveData()

    fun getData(code: String,
                  notlast: String,
                  action: String,
                  date: String,
                  ids: String,
                  time: String) {
        viewModelScope.launch {
            val response = repository.getDAta(code,notlast,action,date,ids,time)
            myDataResponse.value = response
        }
    }

    val logOutResponse: MutableLiveData<Response<LogOutItem>> = MutableLiveData()

    fun logOut(code: String) {
        viewModelScope.launch {
            val response = repository.logOut(code)
            logOutResponse.value = response
        }
    }

}
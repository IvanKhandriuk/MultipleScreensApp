package com.ikhandriuk.multiplescreensapp.Screens.FirstScreen.LogOut

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.Repository.LogOutRepository

class SecondViewModelFactory (
    private val logOutRepository: LogOutRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SecondViewModel(logOutRepository) as T
    }
}
package com.ikhandriuk.multiplescreensapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ikhandriuk.multiplescreensapp.Repository.AuthorizationRepository

class MainViewModelFactory(
    private val authorizationRepository: AuthorizationRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(authorizationRepository) as T
    }
}
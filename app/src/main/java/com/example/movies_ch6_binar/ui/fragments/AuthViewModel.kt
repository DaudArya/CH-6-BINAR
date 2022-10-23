package com.example.movies_ch6_binar.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.movies_ch6_binar.model.UserRepository
import com.example.movies_ch6_binar.util.datastore.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: UserRepository
)  : ViewModel()  {

    fun registerAccount(username: String, email : String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.registerAccount(
                username,
                password,
                email
            )
        }
    }

    fun getAccountData(): LiveData<UserPreferences> {
        return repository.getAccountData().asLiveData()
    }

    fun getLoginStatus(): LiveData<Boolean> {
        return repository.getLoginStatus().asLiveData()
    }

    // Set Data

    fun setLoginStatus(status: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setLoginStatus(status)
        }
    }

    fun setUsername(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setUsername(username)
        }
    }

    fun setEmail(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setEmail(email)
        }
    }

    fun setPassword(password: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.setPassword(password)
        }
    }

    fun setImage(image: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.setImage(image)
        }
    }

}
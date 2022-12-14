package com.example.movies_ch6_binar.ui.Login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies_ch6_binar.Models.usecase.loginuser.LoginUserUseCase
import com.example.movies_ch6_binar.data.UserPreferences
import com.example.movies_ch6_binar.utils.Constant
import com.example.movies_ch6_binar.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCase: LoginUserUseCase,
    private val preferences: UserPreferences
) : ViewModel() {

    private var _state = MutableLiveData(LoginState())
    val state: LiveData<LoginState> = _state

    fun login(email: String, password: String) {
        useCase(email, password).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.postValue(LoginState(user = result.data, result = true, error = ""))
                    Log.d(Constant.TAG, "Login ViewModel -> ${result.data}")
                }
                is Resource.Error -> {
                    _state.postValue(
                        LoginState(
                            error = "Akun tidak ditemukan"
                        )
                    )
                    Log.d(Constant.TAG, "Error ViewModel -> ${result.message}")
                }
                is Resource.Loading -> {
                    _state.postValue(LoginState(isLoading = true))
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun setUser(email: String) {
        preferences.login(email)
    }
}
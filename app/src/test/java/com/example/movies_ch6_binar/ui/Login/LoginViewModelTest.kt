package com.example.movies_ch6_binar.ui.Login

import androidx.lifecycle.viewModelScope
import com.example.movies_ch6_binar.Models.usecase.loginuser.LoginUserUseCase
import com.example.movies_ch6_binar.data.UserPreferences
import com.example.movies_ch6_binar.data.local.room.dao.UserDao
import com.example.movies_ch6_binar.data.repository.AuthRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.jupiter.api.Test

class LoginViewModelTest {
    private lateinit var useCase: LoginUserUseCase
    private lateinit var preferences: UserPreferences
    private lateinit var userDao: UserDao
    private lateinit var repository: AuthRepositoryImpl


    private val expectedValue = LoginViewModel(useCase,preferences).login("zeperion99@gmail.com","adm123")
    private val expectedValue2 = LoginViewModel(useCase,preferences).setUser("zeperion99@gmail.com")
    lateinit var login : LoginViewModel

    @Before
    fun setUp() {
        login = LoginViewModel(useCase,preferences)
    }
    
    @Test
    fun emailnull() = runBlocking{
        val Result = login.login("", "adm123")
        Assert.assertEquals(expectedValue, Result)
    }

    @Test
    fun setUserempty() = runBlocking {
        val result = login.setUser("").toString()
    Assert.assertEquals(expectedValue2, result)
    }
}
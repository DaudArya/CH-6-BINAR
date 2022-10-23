package com.example.movies_ch6_binar.model

import com.example.movies_ch6_binar.util.datastore.DataSource
import com.example.movies_ch6_binar.util.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    //Authentication
    suspend fun registerAccount(username: String, password:String, email:String)
    fun getLoginStatus() : Flow<Boolean>

    //Edit Account Data
    suspend fun setImage(image: String)
    suspend fun setUsername(username: String)
    suspend fun setEmail(email: String)
    suspend fun setPassword(password: String)
    suspend fun setLoginStatus(status: Boolean)

    //Get Account Data
    fun getAccountData() : Flow<UserPreferences>
}

class LocalRepositroyImpl(
    private val localDataSource: DataSource
) : UserRepository{
    override suspend fun registerAccount(username: String, password: String, email: String) {
        localDataSource.registerAccount(username, password, email)
    }

    override fun getLoginStatus(): Flow<Boolean> {
        return localDataSource.getLoginStatus()
    }

    override suspend fun setImage(image: String) {
        localDataSource.setImage(image)
    }

    override suspend fun setUsername(username: String) {
        localDataSource.setUsername(username)
    }

    override suspend fun setEmail(email: String) {
        localDataSource.setEmail(email)
    }

    override suspend fun setPassword(password: String) {
        localDataSource.setPassword(password)
    }

    override suspend fun setLoginStatus(status: Boolean) {
        localDataSource.setLoginStatus(status)
    }

    override fun getAccountData(): Flow<UserPreferences> {
        return localDataSource.getAccountData()
    }

}
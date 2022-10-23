package com.example.movies_ch6_binar.util.datastore

import kotlinx.coroutines.flow.Flow

interface DataSource {

    suspend fun registerAccount(username: String, password:String, email:String)
    fun getLoginStatus() : Flow<Boolean>


    suspend fun setImage(image: String)
    suspend fun setUsername(username: String)
    suspend fun setEmail(email: String)
    suspend fun setPassword(password: String)
    suspend fun setLoginStatus(status: Boolean)


    fun getAccountData() : Flow<UserPreferences>
}

class LocalDataSourceImpl (
    private val dataStoreManager: DataStoreHelper
) : DataSource {

    //Authentication
    override suspend fun registerAccount(username: String, password: String, email: String) {
        dataStoreManager.registerAccount(username, password, email)
    }

    override fun getLoginStatus(): Flow<Boolean> {
        return dataStoreManager.getLoginStatus()
    }

    //Edit Account Data
    override suspend fun setImage(image: String) {
        dataStoreManager.setImage(image)
    }

    override suspend fun setUsername(username: String) {
        dataStoreManager.setUsername(username)
    }

    override suspend fun setEmail(email: String) {
        dataStoreManager.setEmail(email)
    }

    override suspend fun setPassword(password: String) {
        dataStoreManager.setPassword(password)
    }

    override suspend fun setLoginStatus(status: Boolean) {
        dataStoreManager.setStatusLogin(status)
    }

    //Get Account Data
    override fun getAccountData(): Flow<UserPreferences> {
        return dataStoreManager.getAccountData()
    }

}
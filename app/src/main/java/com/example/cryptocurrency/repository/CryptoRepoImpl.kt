package com.example.cryptocurrency.repository

import com.example.cryptocurrency.models.ApiBaseModel
import com.example.cryptocurrency.models.BaseModel
import com.example.cryptocurrency.models.CryptocurrencyList
import com.example.cryptocurrency.network.Api

class CryptoRepoImpl(private val api: Api): CryptoRepo {
    override suspend fun getListing(): BaseModel<ApiBaseModel<CryptocurrencyList>> {
        try {
            api.getListing(
                start = 1,
                limit = 100
            ).also {
                return if (it.isSuccessful){
                    BaseModel.Success(data = it.body()!!)
                } else {
                    BaseModel.Error(error = it.message())
                }
            }
        } catch (e: Exception) {
            return BaseModel.Error(error = e.message.toString())
        }
    }
}
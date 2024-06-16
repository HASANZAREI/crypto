package com.example.cryptocurrency.repository

import com.example.cryptocurrency.models.ApiBaseModel
import com.example.cryptocurrency.models.BaseModel
import com.example.cryptocurrency.models.CryptocurrencyList

interface CryptoRepo {
    suspend fun getListing(): BaseModel<ApiBaseModel<CryptocurrencyList>>
}
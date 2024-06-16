package com.example.cryptocurrency.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.models.ApiBaseModel
import com.example.cryptocurrency.models.BaseModel
import com.example.cryptocurrency.models.CryptocurrencyList
import com.example.cryptocurrency.repository.CryptoRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: ViewModel(), KoinComponent {
    private val repository: CryptoRepo by inject()

    private val _response: MutableStateFlow<BaseModel<ApiBaseModel<CryptocurrencyList>>?> = MutableStateFlow(null)
    val response = _response.asStateFlow()

    fun getListing() {
        viewModelScope.launch {
            _response.update {
                BaseModel.Loading
            }
            repository.getListing().also {res ->
                _response.update { res }
            }
        }
    }

}
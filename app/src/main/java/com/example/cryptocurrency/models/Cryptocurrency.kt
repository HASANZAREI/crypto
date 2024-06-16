package com.example.cryptocurrency.models

data class Cryptocurrency(
    val id: Int,
    val name: String,
    val symbol: String,
    val slug: String,
    val cmcRank: Int,
    val marketPairCount: Int,
    val circulatingSupply: Double,
    val selfReportedCirculatingSupply: Double,
    val totalSupply: Double,
    val ath: Double,
    val atl: Double,
    val high24h: Double,
    val low24h: Double,
    val isActive: Int,
    val isUpdated: String,
    val dateAdded: String,
    val quotes: List<Quotes>,
    val isAudited: Boolean
)

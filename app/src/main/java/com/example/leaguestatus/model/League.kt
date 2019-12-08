package com.example.leaguestatus.model

data class League (
    val leaguePoint: Int,
    val tier: String,
    val rank: String,
    val losses: Int,
    val wins: Int,
    val summonerName: String
)
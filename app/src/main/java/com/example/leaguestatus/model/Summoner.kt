package com.example.leaguestatus.model

data class Summoner(
    val accountId: String,
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val id: String
)
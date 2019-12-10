package com.example.leaguestatus.model

data class User(
    val summoner: Summoner,
    val queue: List<League>
)

data class Summoner(
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val id: String,
    val accountId: String
)

data class League(
    val queueType: String,
    val summonerName: String,
    val hotStreak: Boolean,
    val wins: Int,
    val veteran: Boolean,
    val losses: Int,
    val rank: String,
    val leagueId: String,
    val inactive: Boolean,
    val freshBlood: Boolean,
    val tier: String,
    val summonerId: String,
    val leaguePoints: Int
)


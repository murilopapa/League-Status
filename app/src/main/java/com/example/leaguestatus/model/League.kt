package com.example.leaguestatus.model

data class League(

    val queueType: String,
    val summonerName: String,
    val hotStreak: Boolean,
    val miniSeries: MiniSeriesDTO,
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

data class MiniSeriesDTO(
    val progress: String,
    val losses: Int,
    val target: Int,
    val wins: Int
)
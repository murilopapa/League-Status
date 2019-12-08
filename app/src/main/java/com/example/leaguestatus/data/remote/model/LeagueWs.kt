package com.example.leaguestatus.data.remote.model

import com.example.leaguestatus.data.local.model.LeagueEntity
import com.example.leaguestatus.model.League


data class LeagueWs(
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

fun List<LeagueWs>.toLeague(): List<League> =
    map {
        League(
            it.leaguePoints,
            it.tier,
            it.rank,
            it.losses,
            it.wins,
            it.summonerName
        )
    }

fun List<LeagueWs>.toLeagueEntity(): List<LeagueEntity> =
    map {
        LeagueEntity(
            it.queueType,
            it.summonerName,
            it.hotStreak,
            it.wins,
            it.veteran,
            it.losses,
            it.rank,
            it.leagueId,
            it.inactive,
            it.freshBlood,
            it.tier,
            it.summonerId,
            it.leaguePoints
        )
    }

fun LeagueWs.toLeagueEntity(): LeagueEntity =
    let {
        LeagueEntity(
            it.queueType,
            it.summonerName,
            it.hotStreak,
            it.wins,
            it.veteran,
            it.losses,
            it.rank,
            it.leagueId,
            it.inactive,
            it.freshBlood,
            it.tier,
            it.summonerId,
            it.leaguePoints
        )
    }
package com.example.leaguestatus.data.remote.model

import com.example.leaguestatus.data.local.model.LeagueEntity
import com.example.leaguestatus.model.League
import java.io.Serializable

data class LeagueWs(
    val queueType: String,
    val summonerName: String,
    val hotStreak: Boolean,
    val miniSeries: MiniSeriesWs,
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
) : Serializable


data class MiniSeriesWs(
    val progress: String,
    val losses: Int,
    val target: Int,
    val wins: Int
)

fun LeagueWs.toLeagueEntity(): LeagueEntity =
    let {
        LeagueEntity(
            0,
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

fun LeagueWs.toLeague(): League =
    let {
        League(
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

fun List<LeagueWs>.toLeague(): List<League> =
    map {
        it.toLeague()
    }


fun List<LeagueWs>.toLeagueEntity(): List<LeagueEntity> =
    map {
        it.toLeagueEntity()
    }
package com.example.leaguestatus.data.remote.model

import com.example.leaguestatus.data.local.model.SummonerEntity
import com.example.leaguestatus.model.Summoner
import java.io.Serializable

data class SummonerWs(
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val id: String,
    val accountId: String
) : Serializable

fun SummonerWs.toSummonerEntity(): SummonerEntity =
    let {
        SummonerEntity(
            it.profileIconId,
            it.name,
            it.puuid,
            it.summonerLevel,
            it.revisionDate,
            it.id,
            it.accountId
        )
    }

fun SummonerWs.toSummoner(): Summoner =
    let {
        Summoner(
            it.profileIconId,
            it.name,
            it.puuid,
            it.summonerLevel,
            it.revisionDate,
            it.id,
            it.accountId
        )
    }
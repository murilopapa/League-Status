package com.example.leaguestatus.data.remote.model

import com.example.leaguestatus.data.local.model.SummonerEntity
import java.io.Serializable

data class SummonerWs(
    val accountId: String,
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val id: String
): Serializable

fun List<SummonerWs>.toSummonerEntity(): List<SummonerEntity> =
    map {
        SummonerEntity(
            it.accountId,
            it.profileIconId,
            it.name,
            it.puuid,
            it.summonerLevel,
            it.revisionDate,
            it.id
        )
    }

fun SummonerWs.toSummonerEntity(): SummonerEntity =
    let {
        SummonerEntity(
            it.accountId,
            it.profileIconId,
            it.name,
            it.puuid,
            it.summonerLevel,
            it.revisionDate,
            it.id
        )
    }
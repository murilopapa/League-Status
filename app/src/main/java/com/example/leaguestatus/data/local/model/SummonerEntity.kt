package com.example.leaguestatus.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.leaguestatus.model.Summoner

@Entity
data class SummonerEntity(
    val accountId: String,
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    @PrimaryKey
    val id: String
)

fun List<SummonerEntity>.toSummoner(): List<Summoner> =
    map {
        Summoner(
            it.profileIconId,
            it.name,
            it.summonerLevel,
            it.revisionDate
        )
    }
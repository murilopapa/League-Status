package com.example.leaguestatus.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.leaguestatus.model.Summoner

@Entity
data class SummonerEntity(
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val accountId: String
)

fun SummonerEntity.toSummoner(): Summoner =
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

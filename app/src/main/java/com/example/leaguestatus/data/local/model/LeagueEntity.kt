package com.example.leaguestatus.data.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.leaguestatus.model.League

@Entity(
    foreignKeys = arrayOf(
        ForeignKey(
            entity = SummonerEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("summonerId"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class LeagueEntity(
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
    @PrimaryKey
    val summonerId: String,
    val leaguePoints: Int
)

fun List<LeagueEntity>.toLeague(): List<League> =
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

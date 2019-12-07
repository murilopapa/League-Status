package com.example.leaguestatus.data.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
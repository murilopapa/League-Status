package com.example.leaguestatus.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.leaguestatus.model.User

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int? = 0,
    @Embedded
    val summoner: SummonerEntity,
    @Embedded
    val queue: List<LeagueEntity>
)

@Entity
data class SummonerEntity(
    val accountId: String,
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val id: String
)

@Entity
data class LeagueEntity(
    val queueType: String,
    val summonerName: String,
    val hotStreak: Boolean,
    @Embedded
    val miniSeries: MiniSeriesEntity,
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

@Entity
data class MiniSeriesEntity(
    val progress: String,
    val losses: Int,
    val target: Int,
    val wins: Int
)

fun List<UserEntity>.toUser(): List<User> =
    map {
        User(
            it.summoner,
            it.queue
        )
    }
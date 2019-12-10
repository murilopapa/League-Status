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
    @PrimaryKey(autoGenerate = true)
    val id: Int,
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

fun LeagueEntity.toLeague(): League =
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

fun List<LeagueEntity>.toLeague(): List<League> =
    map {
        it.toLeague()
    }

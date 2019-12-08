package com.example.leaguestatus.model

import com.example.leaguestatus.data.local.model.LeagueEntity
import com.example.leaguestatus.data.local.model.SummonerEntity

data class User(
    val summoner: SummonerEntity,
    val queue: List<LeagueEntity>
)
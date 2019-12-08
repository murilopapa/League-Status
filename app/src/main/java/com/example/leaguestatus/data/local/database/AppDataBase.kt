package com.example.leaguestatus.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.leaguestatus.data.local.dataSource.LeagueEntityDao
import com.example.leaguestatus.data.local.dataSource.SummonerEntityDao
import com.example.leaguestatus.data.local.model.LeagueEntity
import com.example.leaguestatus.data.local.model.SummonerEntity

@Database(entities = [SummonerEntity::class, LeagueEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun summonerEntityDao(): SummonerEntityDao
    abstract fun leagueEntityDao(): LeagueEntityDao
}
package com.example.leaguestatus.data.local.dataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.leaguestatus.data.local.model.SummonerEntity

@Dao
interface SummonerEntityDao {
    @Query("SELECT * FROM SummonerEntity")
    fun getAllSummoners(): List<SummonerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSummoner(summoner: SummonerEntity)
}
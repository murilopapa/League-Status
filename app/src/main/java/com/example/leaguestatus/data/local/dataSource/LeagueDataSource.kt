package com.example.leaguestatus.data.local.dataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.leaguestatus.data.local.model.LeagueEntity

@Dao
interface LeagueEntityDao {
    @Query("SELECT * FROM LeagueEntity")
    fun getAllLeagueData(): List<LeagueEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLeagueData(summoner: LeagueEntity)
}
package com.example.leaguestatus.data.local.dataSource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.leaguestatus.data.local.model.UserEntity

@Dao
interface UserEntityDao {
    @Query("SELECT * FROM UserEntity")
    fun getAllUsersData(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUserData(newUser: UserEntity)
}
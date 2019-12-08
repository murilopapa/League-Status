package com.example.leaguestatus.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.leaguestatus.data.local.dataSource.UserEntityDao
import com.example.leaguestatus.data.local.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userEntityDao(): UserEntityDao
}
package com.example.leaguestatus.data.repository.user

import com.example.leaguestatus.data.local.dataSource.UserEntityDao
import com.example.leaguestatus.data.local.model.UserEntity
import com.example.leaguestatus.data.local.model.toUser
import com.example.leaguestatus.data.remote.dataSource.LeagueRemoteDataSource
import com.example.leaguestatus.data.remote.dataSource.SummonerRemoteDataSource
import com.example.leaguestatus.data.remote.model.toLeagueEntity
import com.example.leaguestatus.data.remote.model.toSummonerEntity

class UserRepository(
    private val entityUserDao: UserEntityDao,
    private val leagueRemoteDataSource: LeagueRemoteDataSource,
    private val summonerRemoteDataSource: SummonerRemoteDataSource
) {
    fun getAllUsers() = entityUserDao.getAllUsersData().toUser()

    fun getNewUser(summonerName: String) =
        if (checkUser(summonerName).contains(true)) {
            entityUserDao.getAllUsersData().toUser()
        } else {
            summonerRemoteDataSource.getSummoner(summonerName).execute().body()?.let { summonerWs ->
                leagueRemoteDataSource.getLeague(summonerWs.id).execute().body()?.let { leagueWs ->

                    entityUserDao.addUserData(
                        UserEntity(
                            null,
                            summonerWs.toSummonerEntity(),
                            leagueWs.toLeagueEntity()
                        )
                    )
                    entityUserDao.getAllUsersData().toUser()
                }
            }
        }


    fun checkUser(summonerName: String) =
        entityUserDao.getAllUsersData().map {
            it.summoner.name == summonerName
        }


}
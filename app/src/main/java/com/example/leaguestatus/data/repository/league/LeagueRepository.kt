package com.example.leaguestatus.data.repository.league

import com.example.leaguestatus.data.local.dataSource.LeagueEntityDao
import com.example.leaguestatus.data.remote.dataSource.LeagueRemoteDataSource
import com.example.leaguestatus.data.remote.model.toLeagueEntity

class LeagueRepository(
    private val entityLeagueDao: LeagueEntityDao,
    private val summonerRemoteDataSource: LeagueRemoteDataSource
) {

    fun getLeague(summonerId: String) =
        summonerRemoteDataSource.getLeague(summonerId).execute().body()?.let {
            entityLeagueDao.addLeagueData(it.toLeagueEntity())
            it.toLeagueEntity()
        }

    fun getAllLeague() = entityLeagueDao.getAllLeagueData()

}
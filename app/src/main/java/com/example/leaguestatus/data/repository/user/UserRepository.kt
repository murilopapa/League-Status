package com.example.leaguestatus.data.repository.user

import com.example.leaguestatus.data.local.dataSource.LeagueEntityDao
import com.example.leaguestatus.data.local.dataSource.SummonerEntityDao
import com.example.leaguestatus.data.local.model.toLeague
import com.example.leaguestatus.data.local.model.toSummoner
import com.example.leaguestatus.data.remote.dataSource.LeagueRemoteDataSource
import com.example.leaguestatus.data.remote.dataSource.SummonerRemoteDataSource
import com.example.leaguestatus.data.remote.model.*
import com.example.leaguestatus.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(
    private val summonerEntityDao: SummonerEntityDao,
    private val leagueEntityDao: LeagueEntityDao,
    private val leagueRemoteDataSource: LeagueRemoteDataSource,
    private val summonerRemoteDataSource: SummonerRemoteDataSource
) {
    suspend fun getAllUsers() =
        withContext(Dispatchers.IO) {
            summonerEntityDao.getAllSummonerData().map { summoner ->
                leagueEntityDao.getAllLeagueData().filter { league ->
                    summoner.id == league.summonerId
                }.let { leagueList ->
                    User(
                        summoner.toSummoner(),
                        leagueList.toLeague()
                    )
                }
            }
        }


    suspend fun getNewSummoner(summonerName: String) =
        withContext(Dispatchers.IO) {
            summonerEntityDao.getAllSummonerData().filter { summoner ->
                summoner.id == summonerName
            }.let { summonerList ->
                if (summonerList.isNullOrEmpty()) {
                    (summonerRemoteDataSource.getSummoner(summonerName).execute().body() as SummonerWs).let { summonerWs ->
                        summonerEntityDao.addUserData(summonerWs.toSummonerEntity())
                        (leagueRemoteDataSource.getLeague(summonerWs.id).execute().body() as List<LeagueWs>).let { leagueList ->
                            leagueEntityDao.addLeagueData(leagueList.toLeagueEntity())
                        }
                    }
                }
            }
            getAllUsers().toMutableList()
        }
}






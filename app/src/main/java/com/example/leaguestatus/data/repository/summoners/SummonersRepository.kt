package com.example.leaguestatus.data.repository.summoners

import com.example.leaguestatus.data.local.dataSource.SummonerEntityDao
import com.example.leaguestatus.data.local.model.SummonerEntity
import com.example.leaguestatus.data.remote.dataSource.SummonerRemoteDataSource
import com.example.leaguestatus.data.remote.model.toSummonerEntity

class SummonersRepository(
    private val entitySummonerDao: SummonerEntityDao,
    private val summonerRemoteDataSource: SummonerRemoteDataSource
) {
    fun getAllSummoners() = entitySummonerDao.getAllSummoners()
    fun getSummoner(summonerName: String): List<SummonerEntity> {
        val result = summonerRemoteDataSource.getSummoner(summonerName)
        result.execute().body()?.let {
            if (entitySummonerDao.getAllSummoners().contains(it.toSummonerEntity())) {
                return entitySummonerDao.getAllSummoners()
            } else {
                entitySummonerDao.addSummoner(it.toSummonerEntity())
                return entitySummonerDao.getAllSummoners()
            }
        } ?: let {
            return entitySummonerDao.getAllSummoners()
        }
    }
}
package com.example.leaguestatus.data.remote.dataSource

import com.example.leaguestatus.data.remote.LeagueStatusWebService

class SummonerRemoteDataSource (private val webService: LeagueStatusWebService){
    fun getSummoner(summonerName: String) =
        webService.getSummoner(summonerName.replace(" ", "%20"))

}
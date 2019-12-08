package com.example.leaguestatus.data.remote.dataSource

import com.example.leaguestatus.data.remote.LeagueStatusWebService

class LeagueRemoteDataSource(private val webService: LeagueStatusWebService) {

    fun getLeague(summonerId: String) = webService.getLeague(summonerId)

}
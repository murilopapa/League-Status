package com.example.leaguestatus.data.remote

import com.example.leaguestatus.data.remote.model.SummonerWs
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LeagueStatusWebService {
    @GET("summoner/v4/summoners/by-name/{summoner}?api_key=RGAPI-1ba23a81-8bb6-4760-a498-07f258f493fa")
    fun getSummoner(@Path("summoner") summoner: String): Call<SummonerWs>
}
package com.example.leaguestatus.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceClient {

    var webService: LeagueStatusWebService

    init {
        webService = retrofitBuilder()
    }

    fun retrofitBuilder() = Retrofit.Builder()
        .baseUrl("https://br1.api.riotgames.com/lol/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(LeagueStatusWebService::class.java)


}
package com.example.leaguestatus.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceClient {

    var webService: LeagueStatusWebService

    init {
        webService = createService()
    }

    private fun createService(): LeagueStatusWebService = retrofitBuilder()

    fun retrofitBuilder() = Retrofit.Builder()
        .baseUrl("https://br1.api.riotgames.com/lol/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build().create(LeagueStatusWebService::class.java)


}
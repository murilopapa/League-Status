package com.example.leaguestatus.data.remote

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebServiceClient {

    var webService: LeagueStatusWebService

    init {
        webService = createLeagueStatusWebService("https://br1.api.riotgames.com/lol/")
    }



    private fun createLeagueStatusWebService(uri: String, gson: Gson = getGson(), timeout: Long = 30000L) =
        createRetrofitAccess(uri, timeout, Interceptor { chain ->
            var request = chain.request()
            val originalHttpUrl = request.url()
            val url = originalHttpUrl.newBuilder().build()

            val builder = request.newBuilder()

            builder.addHeader("X-Riot-Token", "RGAPI-0eab9997-e1f0-4b5a-853e-35ddc87c00b1")
            builder.url(url)

            request = builder.build()
            chain.proceed(request)

        }, gson).create(LeagueStatusWebService::class.java)

    private fun createRetrofitAccess(
        uri: String,
        timeout: Long,
        requestInterceptor: Interceptor,
        gson: Gson = getGson()
    ) =
        Retrofit.Builder().baseUrl(uri).client(
            setupInterceptors(
                requestInterceptor,
                timeout
            ).build()
        ).addConverterFactory(GsonConverterFactory.create(gson)).build()

    private fun setupInterceptors(requestInterceptor: Interceptor, timeout: Long) =
        OkHttpClient.Builder().apply {
            addInterceptor(requestInterceptor)
            addNetworkInterceptor(StethoInterceptor())
            readTimeout(timeout, TimeUnit.SECONDS)
        }


    fun getGson(): Gson = GsonBuilder().create()

}
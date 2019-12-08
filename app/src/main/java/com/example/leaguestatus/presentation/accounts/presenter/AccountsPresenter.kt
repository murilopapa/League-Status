package com.example.leaguestatus.presentation.accounts.presenter

import com.example.leaguestatus.domain.usecases.LeagueUseCase
import com.example.leaguestatus.domain.usecases.SummonerUseCase
import com.example.leaguestatus.mechanism.livedata.MutableLiveDataResource
import com.example.leaguestatus.mechanism.livedata.Resource
import com.example.leaguestatus.model.League
import com.example.leaguestatus.model.Summoner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AccountsPresenter(private val summonerUseCase: SummonerUseCase,
                        private val leagueUseCase: LeagueUseCase
) {
    var summonerLiveData = MutableLiveDataResource<List<Summoner>>()
    var leagueLiveData = MutableLiveDataResource<List<League>>()

    fun getAllSummoners() {
        CoroutineScope(IO).launch {
            summonerLiveData.postValue(Resource.loading())
            summonerUseCase.getAllSummoners().let { summonerList ->
                summonerLiveData.postValue(Resource.success(summonerList))
            }
        }
    }

    fun getSearchedSummoner(summonerName: String) {
        CoroutineScope(IO).launch {
            summonerLiveData.postValue(Resource.loading())
            summonerUseCase.getAllSummoners(summonerName).let {summonerList ->
                summonerLiveData.postValue(Resource.success(summonerList))
            }
        }
    }

    fun getAllLeague() {
        CoroutineScope(IO).launch {
            leagueLiveData.postValue(Resource.loading())
            leagueUseCase.getAllLeague()
        }
    }

}
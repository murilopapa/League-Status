package com.example.leaguestatus.presentation.accounts.presenter

import com.example.leaguestatus.domain.usecases.SummonerUseCase
import com.example.leaguestatus.mechanism.livedata.MutableLiveDataResource
import com.example.leaguestatus.mechanism.livedata.Resource
import com.example.leaguestatus.model.Summoner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AccountsPresenter(private val summonerUseCase: SummonerUseCase) {
    var summonerLiveData = MutableLiveDataResource<List<Summoner>>()

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

}
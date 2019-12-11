package com.example.leaguestatus.presentation.accounts.presenter

import com.example.leaguestatus.domain.usecases.UserUseCase
import com.example.leaguestatus.mechanism.livedata.MutableLiveDataResource
import com.example.leaguestatus.mechanism.livedata.Resource
import com.example.leaguestatus.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AccountsPresenter(
    private val userUseCase: UserUseCase
) {
    var userLiveData = MutableLiveDataResource<List<User>>()

    fun getAllUsers() {
        CoroutineScope(IO).launch {
            userLiveData.postValue(Resource.loading())
            userUseCase.getAllUsers().let {
                userLiveData.postValue(Resource.success(it))
            }
        }
    }


    fun getSearchedSummoner(summonerName: String) {
        CoroutineScope(IO).launch {
            userLiveData.postValue(Resource.loading())
            userUseCase.getSummonerByName(summonerName).let {
                userLiveData.postValue(Resource.success(it))
            }
        }
    }


}

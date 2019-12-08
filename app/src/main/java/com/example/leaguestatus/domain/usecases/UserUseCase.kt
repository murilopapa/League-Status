package com.example.leaguestatus.domain.usecases

import com.example.leaguestatus.data.repository.user.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserUseCase(private val repository: UserRepository) {

    suspend fun getAllUsers() =
        withContext(Dispatchers.IO) {
            repository.getAllUsers()
        }

    suspend fun getSummonerByName(summonerName: String) =
        withContext(Dispatchers.IO) {
            repository.getNewUser(summonerName)
        }


}
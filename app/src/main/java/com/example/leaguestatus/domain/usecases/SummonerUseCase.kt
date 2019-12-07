package com.example.leaguestatus.domain.usecases

import com.example.leaguestatus.data.local.model.toSummoner
import com.example.leaguestatus.data.repository.summoners.SummonersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SummonerUseCase(private val repository: SummonersRepository) {
    suspend fun getAllSummoners(summonerName: String? = null) =
        withContext(Dispatchers.IO)
        {
            summonerName?.let {
                repository.getSummoner(summonerName).toSummoner()
            } ?: let {
                repository.getAllSummoners().toSummoner()
            }

        }
}

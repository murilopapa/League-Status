package com.example.leaguestatus.domain.usecases

import com.example.leaguestatus.data.repository.league.LeagueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeagueUseCase(
    private val repository: LeagueRepository
) {
    suspend fun getAllLeague() = withContext(Dispatchers.IO) {
        repository.getAllLeague()
    }
}
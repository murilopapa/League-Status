package com.example.leaguestatus.dependencies

import androidx.room.Room
import com.example.leaguestatus.data.local.database.AppDataBase
import com.example.leaguestatus.data.remote.WebServiceClient
import com.example.leaguestatus.data.remote.dataSource.LeagueRemoteDataSource
import com.example.leaguestatus.data.remote.dataSource.SummonerRemoteDataSource
import com.example.leaguestatus.data.repository.league.LeagueRepository
import com.example.leaguestatus.data.repository.summoners.SummonersRepository
import com.example.leaguestatus.domain.usecases.LeagueUseCase
import com.example.leaguestatus.domain.usecases.SummonerUseCase
import com.example.leaguestatus.presentation.accounts.presenter.AccountsPresenter
import org.koin.dsl.module.module


val databaseModules = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            "app-database"
        ).build()
    }

    single { get<AppDataBase>().summonerEntityDao() }
}

val presenterModules = module {
    factory {
        AccountsPresenter(get())
    }
}
val repositoryModules = module {
    single { SummonersRepository(get(), get()) }
    single { LeagueRepository(get(), get()) }
}
val useCaseModules = module {
    single { SummonerUseCase(get()) }
    single { LeagueUseCase(get()) }
}

val dataSourceModules = module {
    single { SummonerRemoteDataSource(get()) }
    single { LeagueRemoteDataSource(get()) }
}

val webServiceModules = module {
    single { WebServiceClient().webService }
}

val applicationModules = listOf(
    presenterModules,
    useCaseModules,
    repositoryModules,
    databaseModules,
    webServiceModules,
    dataSourceModules
)
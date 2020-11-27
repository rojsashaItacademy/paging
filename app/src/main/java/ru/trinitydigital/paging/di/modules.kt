package ru.trinitydigital.paging.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.trinitydigital.paging.data.interactors.PagingInteractor
import ru.trinitydigital.paging.data.interactors.PagingInteractorImpl
import ru.trinitydigital.paging.data.remote.RetrofitBuilder
import ru.trinitydigital.paging.data.repositories.PagingRepository
import ru.trinitydigital.paging.data.repositories.PagingRepositoryImpl
import ru.trinitydigital.paging.ui.main.MainViewModel


val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    single<PagingRepository> { PagingRepositoryImpl(get()) }
}

val apiModule = module {
    single { RetrofitBuilder.buildRetrofit() }
    single<PagingInteractor> { PagingInteractorImpl(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)
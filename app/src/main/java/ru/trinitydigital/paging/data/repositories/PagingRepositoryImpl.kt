package ru.trinitydigital.paging.data.repositories

import ru.trinitydigital.paging.data.interactors.PagingInteractor
import ru.trinitydigital.paging.data.model.BasePagingModel
import ru.trinitydigital.paging.data.model.Data

interface PagingRepository {

    suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data>

}

class PagingRepositoryImpl(private val network: PagingInteractor) : PagingRepository {

    override suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data> {
        return network.loadData(limit = limit, offset = offset)
    }

}
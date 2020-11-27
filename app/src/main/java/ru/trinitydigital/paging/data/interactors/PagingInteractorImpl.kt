package ru.trinitydigital.paging.data.interactors

import ru.trinitydigital.paging.data.model.BasePagingModel
import ru.trinitydigital.paging.data.model.Data
import ru.trinitydigital.paging.data.remote.SharesService

interface PagingInteractor {
    suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data>
}

class PagingInteractorImpl(private val service: SharesService) : PagingInteractor {

    override suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data> {
        return service.getShares(
            apiKey = "c06ea77867714c7b46d31197cc5d5d67",
            symbols = "AAPL",
            sort = "DESC",
            limit = limit,
            offset = offset
        )
    }
}
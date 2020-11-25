package ru.trinitydigital.paging.data.interactors

import ru.trinitydigital.paging.data.model.BasePagingModel
import ru.trinitydigital.paging.data.model.Data
import ru.trinitydigital.paging.data.remote.SharesService

interface PagingInteractor {
    suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data>
}

class PagingInteractorImpl(private val service: SharesService) : PagingInteractor {
    override suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data> {
        return service.getShares(" asdasdsad", "asdasdsad", "adasdasd", limit, offset)
    }
}
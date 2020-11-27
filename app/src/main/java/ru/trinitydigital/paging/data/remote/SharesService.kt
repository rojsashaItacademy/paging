package ru.trinitydigital.paging.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.trinitydigital.paging.data.model.BasePagingModel
import ru.trinitydigital.paging.data.model.Data

interface SharesService {

    @GET("eod")
    suspend fun getShares(
        @Query("access_key") apiKey: String,
        @Query("symbols") symbols: String,
        @Query("sort") sort: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): BasePagingModel<Data>
}

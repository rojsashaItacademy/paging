package ru.trinitydigital.paging.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    fun buildRetrofit(): SharesService {
        return Retrofit.Builder()
            .baseUrl("http://api.marketstack.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SharesService::class.java)
    }
}

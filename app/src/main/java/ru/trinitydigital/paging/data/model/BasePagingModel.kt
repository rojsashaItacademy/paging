package ru.trinitydigital.paging.data.model

import com.google.gson.annotations.SerializedName
import ru.trinitydigital.paging.data.model.Data
import ru.trinitydigital.paging.data.model.Pagination

data class BasePagingModel<T> (

	@SerializedName("pagination") val pagination : Pagination,
	@SerializedName("data") val data : List<T>
)
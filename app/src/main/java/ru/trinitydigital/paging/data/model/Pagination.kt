package ru.trinitydigital.paging.data.model

import com.google.gson.annotations.SerializedName

data class Pagination (

	@SerializedName("limit") val limit : Int,
	@SerializedName("offset") val offset : Int,
	@SerializedName("count") val count : Int,
	@SerializedName("total") val total : Int
)
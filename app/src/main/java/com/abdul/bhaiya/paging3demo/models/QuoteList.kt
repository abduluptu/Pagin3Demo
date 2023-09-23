package com.abdul.bhaiya.paging3demo.models

import com.google.gson.annotations.SerializedName

//step2: create model class with the help of json response

data class QuoteList(
    @SerializedName("count")
    val count: Int,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)
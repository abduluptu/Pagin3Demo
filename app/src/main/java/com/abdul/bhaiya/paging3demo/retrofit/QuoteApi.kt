package com.abdul.bhaiya.paging3demo.retrofit

import com.abdul.bhaiya.paging3demo.models.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

//step5: create an api interface

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) : QuoteList
}
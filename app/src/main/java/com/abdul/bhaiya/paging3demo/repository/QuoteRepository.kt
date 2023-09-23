package com.abdul.bhaiya.paging3demo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.abdul.bhaiya.paging3demo.paging.QuotePagingSource
import com.abdul.bhaiya.paging3demo.retrofit.QuoteApi
import javax.inject.Inject

//step8: create a Repository class

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {

    fun getQuotes() = Pager(
        //pageSize -> number of records in a single page, maxSize -> maximum page size
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource(quoteApi) }
    ).liveData
}
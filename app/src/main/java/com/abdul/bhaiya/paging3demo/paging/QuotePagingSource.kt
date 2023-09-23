package com.abdul.bhaiya.paging3demo.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.abdul.bhaiya.paging3demo.models.Result
import com.abdul.bhaiya.paging3demo.retrofit.QuoteApi

//step7: create a Paging Source class and write logic load page & refresh

class QuotePagingSource(private val quoteApi: QuoteApi) :
    PagingSource<Int, Result>() { //key-> page(Int), value->Response(Result)

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {

        return try {
            //get page position by key if it is null then load first page(1)
            val position = params.key ?: 1
            //get response by passing page number
            val response = quoteApi.getQuotes(position)

            //load data
            return LoadResult.Page(
                //data from response, which want to load
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    //If this function return null then paging library load the first page
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        //https://developer.android.com/reference/kotlin/androidx/paging/PagingSource

        //Most recently accessed index in the list
        // val anchorPosition:Int?

        //This function can be called  with anchorPosition to fetch the loaded pages
        //that is closest to the last accessed index in the list
        /*fun closestPageToPosition(anchorPosition: Int){

        }*/

        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }

        //It is the same as above code
       /* if (state.anchorPosition != null) {
            val anchorPage = state.closestPageToPosition(state.anchorPosition!!)
            if (anchorPage?.prevKey != null) {
                return anchorPage.prevKey!!.plus(1)
            } else if (anchorPage?.nextKey != null) {
                return anchorPage.nextKey!!.minus(1)
            }
        } else {
            return null
        }*/

    }
}
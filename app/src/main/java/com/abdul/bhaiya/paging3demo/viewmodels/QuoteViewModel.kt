package com.abdul.bhaiya.paging3demo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.abdul.bhaiya.paging3demo.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//step12: create a view model

@HiltViewModel
class QuoteViewModel @Inject constructor(private val quoteRepository: QuoteRepository) : ViewModel(){
    //list will be of LiveData type, cachedIn---> pagging data will be cache in coroutines scope
    val list = quoteRepository.getQuotes().cachedIn(viewModelScope)
}
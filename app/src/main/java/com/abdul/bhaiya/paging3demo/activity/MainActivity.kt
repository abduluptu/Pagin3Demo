package com.abdul.bhaiya.paging3demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdul.bhaiya.paging3demo.R
import com.abdul.bhaiya.paging3demo.paging.QuotePagingAdapter
import com.abdul.bhaiya.paging3demo.viewmodels.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

//step13: Observe View model inside MainActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var quoteViewModel: QuoteViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: QuotePagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.quoteList)

        quoteViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)

        adapter = QuotePagingAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        quoteViewModel.list.observe(this, Observer {
            //lifecycle -> Activity lifecycle, it -> Paging Data
            adapter.submitData(lifecycle, it)
        })
    }
}
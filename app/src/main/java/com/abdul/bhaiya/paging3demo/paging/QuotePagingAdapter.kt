package com.abdul.bhaiya.paging3demo.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.abdul.bhaiya.paging3demo.R
import com.abdul.bhaiya.paging3demo.models.Result

//step11: create a paging adapter

class QuotePagingAdapter : PagingDataAdapter<Result, QuotePagingAdapter.QuoteViewHolder>(COMPARATOR) {

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.quote.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_quote_layout, parent, false)
        return QuoteViewHolder(view)
    }

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quote = itemView.findViewById<TextView>(R.id.quote)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                //if two items id's same, those items will be same
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                //to check two items contents (values) are same
                return oldItem == newItem
            }
        }
    }
}
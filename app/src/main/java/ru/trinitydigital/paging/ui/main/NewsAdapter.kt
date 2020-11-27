package ru.trinitydigital.paging.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import ru.trinitydigital.paging.R
import ru.trinitydigital.paging.data.model.Data


class NewsAdapter : PagedListAdapter<Data, NewsViewHolder>(DiffUtils.diffUtilData) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)

        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}
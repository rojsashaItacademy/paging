package ru.trinitydigital.paging.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*
import ru.trinitydigital.paging.data.model.Data

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Data?, position: Int) {
        itemView.tvTitle.text = "$position _____ ${item?.date}"
    }
}
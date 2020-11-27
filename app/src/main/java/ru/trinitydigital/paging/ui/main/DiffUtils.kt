package ru.trinitydigital.paging.ui.main

import androidx.recyclerview.widget.DiffUtil
import ru.trinitydigital.paging.data.model.Data

object DiffUtils {

    val diffUtilData = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.date == newItem.date &&
                    oldItem.adj_close == newItem.adj_close &&
                    oldItem.adj_high == newItem.adj_high &&
                    oldItem.adj_open == newItem.adj_open &&
                    oldItem.close == newItem.close
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }
}
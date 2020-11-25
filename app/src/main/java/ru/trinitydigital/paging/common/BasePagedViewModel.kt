package ru.trinitydigital.paging.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

abstract class BasePagedViewModel<T, D : BaseDataSource<T>> : ViewModel() {

    abstract val sourceFactory: BaseDataSource.Factory<T, D>

    fun getPagedList(): LiveData<PagedList<T>> {
        return LivePagedListBuilder(
            sourceFactory,
            PagedList.Config.Builder()
                .build()
        ).build()
    }
}
package ru.trinitydigital.paging.ui.main

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import ru.trinitydigital.paging.common.BaseDataSource
import ru.trinitydigital.paging.common.BasePagedViewModel
import ru.trinitydigital.paging.data.model.BasePagingModel
import ru.trinitydigital.paging.data.model.Data
import ru.trinitydigital.paging.data.repositories.PagingRepository

class MainViewModel(private val service: PagingRepository) : BasePagedViewModel<Data, MainViewModel.MainDataSource>() {

    override val sourceFactory: BaseDataSource.Factory<Data, MainDataSource>
        get() = TODO("Not yet implemented")


    inner class MainDataSource(
        scope: CoroutineScope
    ) : BaseDataSource<Data>(scope) {

        override fun getListByPageNumber(offset: Int, limit: Int): BasePagingModel<Data>? {
            return runBlocking {
                return@runBlocking service.loadData(offset ,limit)

            }
        }
    }
}
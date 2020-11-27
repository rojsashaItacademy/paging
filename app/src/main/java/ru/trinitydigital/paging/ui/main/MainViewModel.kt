package ru.trinitydigital.paging.ui.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import ru.trinitydigital.paging.common.BaseDataSource
import ru.trinitydigital.paging.common.BasePagedViewModel
import ru.trinitydigital.paging.data.interactors.PagingInteractorImpl
import ru.trinitydigital.paging.data.model.BasePagingModel
import ru.trinitydigital.paging.data.model.Data
import ru.trinitydigital.paging.data.remote.RetrofitBuilder
import ru.trinitydigital.paging.data.repositories.PagingRepository
import ru.trinitydigital.paging.data.repositories.PagingRepositoryImpl

class MainViewModel(private val repository: PagingRepository) :
    BasePagedViewModel<Data, MainViewModel.MainDataSource>() {

    override val sourceFactory by lazy {
        BaseDataSource.Factory {
            MainDataSource(viewModelScope)
        }
    }

    val data = getPagedList()

    inner class MainDataSource(
        scope: CoroutineScope
    ) : BaseDataSource<Data>(scope) {

        override fun getListByPageNumber(offset: Int, limit: Int): BasePagingModel<Data>? {
            return runBlocking {
                return@runBlocking repository.loadData(offset = offset, limit = limit)

            }
        }
    }
}
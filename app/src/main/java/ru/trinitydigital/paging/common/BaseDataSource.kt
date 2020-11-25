package ru.trinitydigital.paging.common

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.trinitydigital.paging.data.model.BasePagingModel

abstract class BaseDataSource<T>(
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, T>() {

    abstract fun getListByPageNumber(offset: Int, limit: Int): BasePagingModel<T>?

    private val limit = 20
    private val offset = 20

    class Factory<T, D : BaseDataSource<T>>(private val factory: () -> D) :
        DataSource.Factory<Int, T>() {
        val dataSourceFactoryLiveData = MutableLiveData<BaseDataSource<T>>()

        override fun create() = factory().apply { dataSourceFactoryLiveData.postValue(this) }
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, T>
    ) {
        scope.launch(Dispatchers.IO) {
            runCatching {
                val result = getListByPageNumber(offset = 0, limit = limit)
                result?.data?.let { callback.onResult(it, 0, 1) }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        runCatching {
            val result = getListByPageNumber(offset = 20 * params.key, limit = limit)
            result?.data?.let { callback.onResult(it, params.key + 1) }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
    }
}
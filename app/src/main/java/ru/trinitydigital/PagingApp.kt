package ru.trinitydigital

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.trinitydigital.paging.di.appModules

class PagingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PagingApp)
            modules(appModules)
        }
    }
}


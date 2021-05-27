package com.pedrogomez.carsstore

import android.app.Application
import com.pedrogomez.carsstore.di.carsRepository
import com.pedrogomez.carsstore.di.dbInstance
import com.pedrogomez.carsstore.di.viewModelInstance
import com.pedrogomez.carsstore.di.viewToDbMapper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CarsStoreAplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(
                this@CarsStoreAplication
            )
            androidLogger()
            modules(
                listOf(
                    dbInstance,
                    viewToDbMapper,
                    carsRepository,
                    viewModelInstance
                )
            )
        }
    }

}
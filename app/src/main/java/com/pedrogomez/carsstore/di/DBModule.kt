package com.pedrogomez.carsstore.di

import androidx.room.Room
import com.pedrogomez.carsstore.repository.CarsDB
import com.pedrogomez.carsstore.repository.CarsLocalRepo
import com.pedrogomez.carsstore.repository.RepositoryContract
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbInstance = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            CarsDB::class.java,
            "carsStore.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val carsRepository = module{
    single<RepositoryContract>{
        CarsLocalRepo(
            get<CarsDB>().cars()
        )
    }
}
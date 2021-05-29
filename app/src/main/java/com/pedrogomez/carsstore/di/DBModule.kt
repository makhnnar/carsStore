package com.pedrogomez.carsstore.di

import androidx.room.Room
import com.pedrogomez.carsstore.domian.mapper.MapperContract
import com.pedrogomez.carsstore.domian.mapper.ViewToDBMapper
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
        ).createFromAsset("database/categories.db")
            .build()
    }
}

val viewToDbMapper = module{
    single<MapperContract>{
        ViewToDBMapper()
    }
}

val carsRepository = module{
    single<RepositoryContract>{
        CarsLocalRepo(
            get<CarsDB>().cars(),
            get()
        )
    }
}
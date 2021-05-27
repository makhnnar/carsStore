package com.pedrogomez.carsstore.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pedrogomez.carsstore.domian.Car
import com.pedrogomez.carsstore.domian.Category

@Database(entities = [Car::class,Category::class], version = 1)
abstract class CarsDB : RoomDatabase() {

    abstract fun cars() : CarsDao

}
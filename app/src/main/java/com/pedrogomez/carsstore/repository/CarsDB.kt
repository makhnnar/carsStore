package com.pedrogomez.carsstore.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.db.Value

@Database(entities = [Car::class, Category::class, Value::class], version = 1)
abstract class CarsDB : RoomDatabase() {

    abstract fun cars() : CarsDao

}
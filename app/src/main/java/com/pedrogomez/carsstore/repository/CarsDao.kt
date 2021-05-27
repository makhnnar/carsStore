package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pedrogomez.carsstore.domian.Car
import com.pedrogomez.carsstore.domian.Category
import com.pedrogomez.carsstore.domian.Value

@Dao
interface CarsDao {

    @Insert
    fun insertNewCategory(category: Category)

    @Insert
    fun insertNewValue(value: Value)

    @Insert
    fun insertNewCar(car: Car)

    @Update
    fun updateCategory(category: Category)

    @Update
    fun updateValue(value: Value)

    @Update
    fun updateCar(car: Car)

    @Query(value = "SELECT * from car")
    fun getCars(filter:Boolean = false): LiveData<List<Car>>



}
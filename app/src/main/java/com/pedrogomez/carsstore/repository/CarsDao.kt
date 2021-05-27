package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.db.Value
import com.pedrogomez.carsstore.domian.view.CarModel

@Dao
interface CarsDao {

    @Insert
    suspend fun insertNewCategory(category: Category) : Long

    @Insert
    suspend fun insertNewValue(value: Value) : Long

    @Insert
    suspend fun insertNewCar(car: Car) : Long

    @Update
    suspend fun updateValue(value: Value)

    @Update
    suspend fun updateCar(car: Car)

    @Transaction
    open suspend fun addCarWithValue(
            car: Car,
            value: Value?
    ){
        value?.let {
            car.idValue = insertNewValue(it)
        }
        insertNewCar(car)
    }

    @Transaction
    open suspend fun updateCarWithValue(
            car: Car,
            value: Value?
    ){
        value?.let {
            updateValue(it)
        }
        updateCar(car)
    }

    @Query(
        "SELECT car.id, car.cantSeats, car.price, car.isNew, " +
        "car.model, car.dateRelease, category.id AS categoryId,category.name AS categoryName, " +
        "category.valueName, value.id AS valueQuantityId,value.quantity AS valueQuantity, " +
        "value.unit AS valueQuantityUnit FROM car LEFT JOIN category ON car.idCategory =" +
        " category.id LEFT JOIN value ON car.idValue = value.id"
    )
    fun getAllCars(): LiveData<List<CarModel>>

    @Query("SELECT * FROM category")
    fun getAllCategories(): LiveData<List<Category>>

}
package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pedrogomez.carsstore.domian.CarIds
import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.db.Value
import com.pedrogomez.carsstore.domian.view.CarModel

@Dao
interface CarsDao {

    @Insert
    fun insertNewCategory(category: Category) : Long

    @Insert
    fun insertNewValue(value: Value) : Long

    @Insert
    fun insertNewCar(car: Car) : Long

    @Update
    fun updateCategory(category: Category)

    @Update
    fun updateValue(value: Value)

    @Update
    fun updateCar(car: Car)

    @Query(value = "SELECT idCategory, idValue from car WHERE id=:idCar")
    fun getCarIds(idCar:Long): CarIds

    @Query(
        "SELECT car.id, car.cantSeats, car.price, car.isNew, " +
        "car.model, car.dateRelease, category.name AS categoryName, " +
        "category.valueName, value.quantity AS valueQuantity, value.unit" +
        " AS valueUnit FROM car LEFT JOIN category ON car.idCategory =" +
        " category.id LEFT JOIN value ON car.idValue = value.id"
    )
    fun getAllCars(): LiveData<List<CarModel>>

}
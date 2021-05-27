package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.view.CarModel

interface RepositoryContract {

    suspend fun addCar(carModel: CarModel)

    suspend fun updateCar(carModel: CarModel)

    suspend fun getCars() : LiveData<List<CarModel>>

    suspend fun addCategory(category: Category)

    suspend fun getCategories() : LiveData<List<Category>>

}
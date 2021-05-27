package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.domian.view.CategoryModel

interface RepositoryContract {

    fun addCar(carModel: CarModel)

    fun updateCar(carModel: CarModel)

    fun getCars() : LiveData<List<CarModel>>

    fun addCategory(categoryModel: CategoryModel)

    fun getCategories() : LiveData<List<CategoryModel>>

}
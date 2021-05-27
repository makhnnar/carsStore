package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pedrogomez.carsstore.domian.mapper.MapperContract
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.domian.view.CategoryModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CarsLocalRepo(
        private val carsDao: CarsDao,
        private val mapperContract: MapperContract,
        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepositoryContract {

    override fun addCar(carModel: CarModel) {
        carsDao.addCarWithValue()
    }

    override fun updateCar(carModel: CarModel) {

    }

    override fun getCars(): LiveData<List<CarModel>> {
        return MutableLiveData()
    }

    override fun addCategory(categoryModel: CategoryModel) {

    }

    override fun getCategories(): LiveData<List<CategoryModel>> {
        return MutableLiveData()
    }

}
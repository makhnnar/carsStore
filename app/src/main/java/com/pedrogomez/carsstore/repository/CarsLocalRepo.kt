package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.mapper.MapperContract
import com.pedrogomez.carsstore.domian.view.CarModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CarsLocalRepo(
        private val carsDao: CarsDao,
        private val mapperContract: MapperContract,
        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepositoryContract {

    override suspend fun addCar(carModel: CarModel) {
        carsDao.addCarWithValue(
                mapperContract.getCarAsModelForDB(carModel),
                mapperContract.getValueAsModelForDB(carModel)
        )
    }

    override suspend fun updateCar(carModel: CarModel) {
        carsDao.updateCarWithValue(
            mapperContract.getCarAsModelForDB(carModel),
            mapperContract.getValueAsModelForDB(carModel)
        )
    }

    override fun getCars(): LiveData<List<CarModel>> {
        return carsDao.getAllCars()
    }

    override suspend fun addCategory(category : Category) {
        carsDao.insertNewCategory(category)
    }

    override fun getCategories(): LiveData<List<Category>> {
        return carsDao.getAllCategories()
    }

}
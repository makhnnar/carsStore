package com.pedrogomez.carsstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.db.Value
import com.pedrogomez.carsstore.domian.mapper.MapperContract
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.utils.DataHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


import org.junit.After

@RunWith(AndroidJUnit4::class)
class CarsLocalRepoTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    lateinit var SUT: CarsLocalRepo

    var carsDaoTD = CarsDaoTD()

    var mapperContractTD = MapperContractTD()

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        SUT = CarsLocalRepo(
            carsDaoTD,
            mapperContractTD
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun addCarSuccesPassedToDao() {
        runBlocking {
            launch(Dispatchers.Main) {
                SUT.addCar(
                    DataHelper.carView
                )
                assert(carsDaoTD.car==DataHelper.carDB)
                assert(carsDaoTD.value==DataHelper.valueDB)
            }
        }
    }

    class CarsDaoTD : CarsDao {

        var value: Value? =null

        var car: Car? = null

        override suspend fun insertNewCategory(
                category: Category
        ): Long {
            return 1
        }

        override suspend fun insertNewValue(
                value: Value
        ): Long {
            this.value = value
            return 1
        }

        override suspend fun insertNewCar(car: Car): Long {
            this.car = car
            return 1
        }

        override suspend fun updateCategory(category: Category) {

        }

        override suspend fun updateValue(value: Value) {

        }

        override suspend fun updateCar(car: Car) {

        }

        override fun getAllCars(): LiveData<List<CarModel>> {
            return MutableLiveData()
        }

        override fun getAllCategories(): LiveData<List<Category>> {
            return MutableLiveData()
        }

    }

    class MapperContractTD : MapperContract {

        override fun getCarAsModelForDB(carModel: CarModel): Car {
            return DataHelper.carDB
        }

        override fun getValueAsModelForDB(carModel: CarModel): Value? {
            return DataHelper.valueDB
        }

    }

}





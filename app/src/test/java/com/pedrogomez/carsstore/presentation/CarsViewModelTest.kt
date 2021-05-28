package com.pedrogomez.carsstore.presentation

import androidx.lifecycle.LiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.repository.RepositoryContract
import com.pedrogomez.carsstore.utils.DataHelper
import com.pedrogomez.carsstore.utils.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class CarsViewModelTest {

    lateinit var SUT: CarsViewModel

    var repositoryContractTD = RepositoryContractTD()

    @Before
    fun setUp() {
        SUT = CarsViewModel(
            repositoryContractTD
        )
    }

    @Test
    fun getAllCars(){
        runBlocking {
            assertEquals(
                SUT.carsList,
                DataHelper.carsListLD
            )
        }
    }

    @Test
    fun getAllCategories(){
        runBlocking {
            assertEquals(
                SUT.categoriesList,
                DataHelper.categoriesListLD
            )
        }
    }

    @Test
    fun addCarToDB(){
        runBlocking {
            SUT.addCar(DataHelper.carView)
            assertEquals(
                repositoryContractTD.carModel,
                DataHelper.carView
            )
        }
    }

    @Test
    fun addCategoryToDB(){
        runBlocking {
            SUT.addCategory(DataHelper.categoryDB)
            assertEquals(
                repositoryContractTD.category,
                DataHelper.categoryDB
            )
        }
    }

    @Test
    fun updateCarInDB(){
        runBlocking {
            SUT.updateCar(DataHelper.carView)
            assertEquals(
                repositoryContractTD.carModel,
                DataHelper.carView
            )
        }
    }

    @Test
    fun checkSelectedCarDetail(){
        runBlocking {
            SUT.setCarDetail(DataHelper.carView)
            assertEquals(
                SUT.getCarDetail().getOrAwaitValue(),
                DataHelper.carView
            )
        }
    }

    class RepositoryContractTD : RepositoryContract {

        var carModel: CarModel? = null

        var category: Category? = null

        override suspend fun addCar(carModel: CarModel) {
            this.carModel = carModel
        }

        override suspend fun updateCar(carModel: CarModel) {
            this.carModel = carModel
        }

        override fun getCars(): LiveData<List<CarModel>> {
            return DataHelper.carsListLD
        }

        override suspend fun addCategory(category: Category) {
            this.category = category
        }

        override fun getCategories(): LiveData<List<Category>> {
            return DataHelper.categoriesListLD
        }

    }

}



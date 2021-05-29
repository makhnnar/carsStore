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
    fun checkCarDetailToView(){
        runBlocking {
            SUT.setCarToView(DataHelper.carView)
            assertEquals(
                SUT.getCarToView().getOrAwaitValue(),
                DataHelper.carView
            )
        }
    }

    @Test
    fun checkCarDetailToEdit(){
        runBlocking {
            SUT.setCarToEdit(DataHelper.carView)
            assertEquals(
                SUT.getCarToEdit().getOrAwaitValue(),
                DataHelper.carView
            )
        }
    }

    @Test
    fun saveCarWithEditNotNull(){
        runBlocking {
            SUT.setCarToEdit(DataHelper.carView)
            SUT.getCarToEdit().getOrAwaitValue()
            SUT.saveCar(DataHelper.carView)
            assert(
                repositoryContractTD.callUpdateCar
            )
        }
    }

    @Test
    fun saveCarWithEditNull(){
        runBlocking {
            SUT.setCarToEdit(null)
            SUT.getCarToEdit().getOrAwaitValue()
            SUT.saveCar(DataHelper.carView)
            assert(
                repositoryContractTD.callAddCar
            )
        }
    }

    class RepositoryContractTD : RepositoryContract {

        var carModel: CarModel? = null

        var category: Category? = null

        var callAddCar = false

        var callUpdateCar = false

        override suspend fun addCar(carModel: CarModel) {
            callAddCar = true
            this.carModel = carModel
        }

        override suspend fun updateCar(carModel: CarModel) {
            callUpdateCar = true
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



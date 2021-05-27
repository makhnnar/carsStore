package com.pedrogomez.carsstore.repository

import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.utils.DataHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.junit.After
import org.junit.Assert.*
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito.*
import org.mockito.ArgumentCaptor.*
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class CarsLocalRepoTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    lateinit var SUT: CarsLocalRepo

    @Mock
    lateinit var carsDaoMock : CarsDao

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        SUT = CarsLocalRepo(
            carsDaoMock
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
                verify(carsDaoMock).insertNewCar(
                    DataHelper.carDB
                )
            }
        }
    }

}
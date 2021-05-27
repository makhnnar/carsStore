package com.pedrogomez.carsstore.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CarsLocalRepo(
    private val carsDao: CarsDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : RepositoryContract {

}
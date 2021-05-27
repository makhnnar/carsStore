package com.pedrogomez.carsstore.presentation

import androidx.lifecycle.ViewModel
import com.pedrogomez.carsstore.repository.RepositoryContract

class CarsViewModel(
    private val contract: RepositoryContract
) : ViewModel() {

}
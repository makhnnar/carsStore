package com.pedrogomez.carsstore.presentation

import androidx.lifecycle.*
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.repository.RepositoryContract
import kotlinx.coroutines.launch

class CarsViewModel(
    private val contract: RepositoryContract
) : ViewModel() {

    val carsList : LiveData<List<CarModel>> = contract.getCars()

    val categoriesList : LiveData<List<Category>> = contract.getCategories()

    fun addCar(carFromView: CarModel) {
        viewModelScope.launch {
            contract.addCar(carFromView)
        }
    }

    fun addCategory(category: Category) {
        viewModelScope.launch {
            contract.addCategory(category)
        }
    }

}
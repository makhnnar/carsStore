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

    private var carDetailToView : MutableLiveData<CarModel> = MutableLiveData()

    private var carDetailToEdit : MutableLiveData<CarModel?> = MutableLiveData()

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

    fun updateCar(carFromView: CarModel) {
        viewModelScope.launch {
            contract.updateCar(carFromView)
        }
    }

    fun setCarToView(carFromView: CarModel){
        carDetailToView.postValue(
            carFromView
        )
    }

    fun getCarToView() = carDetailToView

    fun setCarToEdit(carFromView: CarModel?){
        carDetailToEdit.postValue(
            carFromView
        )
    }

    fun getCarToEdit() = carDetailToEdit

    fun saveCar(carFromView: CarModel) {
        viewModelScope.launch {
            if(carDetailToEdit.value!=null){
                contract.updateCar(carFromView)
            }else{
                contract.addCar(carFromView)
            }
        }

    }

}
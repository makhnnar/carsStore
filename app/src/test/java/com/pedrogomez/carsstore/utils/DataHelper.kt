package com.pedrogomez.carsstore.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.db.Value
import com.pedrogomez.carsstore.domian.view.CarModel

class DataHelper {

    companion object{

        val carView = CarModel(
            1,
            0,
            0.0,
            true,
            "model",
            "dateRelease",
            0,
            "categoryName",
            "valueName",
            0,
            0.0,
            "valueUnit"
        )

        val carDB = Car(
            1,
            0,
            0.0,
            true,
            "model",
            "dateRelease",
            1,
            1
        )

        val categoryDB = Category(
            1,
            "name",
            "value"
        )

        val valueDB = Value(
            1,
            0.0,
            "unit"
        )

        val listCategories = listOf(
            categoryDB
        )

        val categoriesListLD = liveData<List<Category>> { listCategories }

        val listCars = listOf(
            carView
        )

        val carsListLD = liveData<List<CarModel>> { listCars }

    }

}
package com.pedrogomez.carsstore.utils

import com.pedrogomez.carsstore.domian.db.Car
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
            "categoryName",
            "valueName",
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
    }

}
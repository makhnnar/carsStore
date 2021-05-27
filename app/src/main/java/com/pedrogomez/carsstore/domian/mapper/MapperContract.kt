package com.pedrogomez.carsstore.domian.mapper

import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.db.Value
import com.pedrogomez.carsstore.domian.view.CarModel

interface MapperContract {

    fun getCarAsModelForDB(carModel: CarModel) : Car

    fun getValueAsModelForDB(carModel: CarModel) : Value?

}
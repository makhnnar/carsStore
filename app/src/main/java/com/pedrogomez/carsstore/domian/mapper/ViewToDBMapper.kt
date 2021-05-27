package com.pedrogomez.carsstore.domian.mapper

import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Value
import com.pedrogomez.carsstore.domian.view.CarModel

class ViewToDBMapper : MapperContract {

    override fun getCarAsModelForDB(carModel: CarModel): Car {
        return Car()
    }

    override fun getValueAsModelForDB(carModel: CarModel): Value? {
        return Value()
    }

}
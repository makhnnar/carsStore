package com.pedrogomez.carsstore.domian.mapper

import com.pedrogomez.carsstore.domian.db.Car
import com.pedrogomez.carsstore.domian.db.Value
import com.pedrogomez.carsstore.domian.view.CarModel

class ViewToDBMapper : MapperContract {

    override fun getCarAsModelForDB(carModel: CarModel): Car {
        return Car(
                carModel.id?:0,
                carModel.cantSeats?:"0",
                carModel.price?:"0",
                carModel.isNew?:true,
                carModel.model?:"",
                carModel.dateRelease?:"",
                carModel.categoryId?:1,
                carModel.valueQuantityId,
        )
    }

    override fun getValueAsModelForDB(carModel: CarModel): Value? {
        if(carModel.valueQuantity!=null && carModel.valueQuantityUnit!=null){
            return Value(
                    carModel.valueQuantityId?:0,
                    carModel.valueQuantity?:"",
                    carModel.valueQuantityUnit?:"",
            )
        }
        return null
    }

}
package com.pedrogomez.carsstore.proxies

import com.pedrogomez.carsstore.domian.view.CarModel

interface ValueContract {

    fun checkFields(
            carFromView: CarModel,
            valueActions: ValueActions
    )

}
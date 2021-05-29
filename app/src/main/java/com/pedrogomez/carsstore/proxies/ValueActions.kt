package com.pedrogomez.carsstore.proxies

import com.pedrogomez.carsstore.domian.view.CarModel

interface ValueActions {

    fun onAcceptValidation(carFromView: CarModel)

    fun onDeniedValidation(msg:String)

}
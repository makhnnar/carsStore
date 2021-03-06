package com.pedrogomez.carsstore.proxies

import com.pedrogomez.carsstore.domian.view.CarModel

//not implemented. was dessingned for carmodel fields validation
class ValueProxy : ValueContract {

    override fun checkFields(
            carFromView: CarModel,
            valueActions: ValueActions
    ) {
        if(carFromView.valueName?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }
        if(carFromView.categoryName?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }
        if(carFromView.dateRelease?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }
        if(carFromView.model?.isEmpty() == true){
            valueActions.onDeniedValidation("")
            return
        }
        valueActions.onAcceptValidation(carFromView)
    }

}
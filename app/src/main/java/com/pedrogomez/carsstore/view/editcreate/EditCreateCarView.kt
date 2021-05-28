package com.pedrogomez.carsstore.view.editcreate

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pedrogomez.carsstore.databinding.ViewEditCreateBinding
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.view.CarModel

class EditCreateCarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    var binding : ViewEditCreateBinding = ViewEditCreateBinding.inflate(
        LayoutInflater.from(context), this, true
    )
    private var etModel : AppCompatEditText? = null

    private var etPrice : AppCompatEditText? = null

    private var sState : AppCompatSpinner? = null

    private var etSeats : AppCompatEditText? = null

    private var etDate : AppCompatEditText? = null

    private var sCategory : AppCompatSpinner? = null

    private var etCategory : AppCompatEditText? = null

    private var etCatValue : AppCompatEditText? = null

    private var lbCatValue : AppCompatTextView? = null

    private var btnSaveCar : FloatingActionButton? = null

    private var btnSaveCategory : FloatingActionButton? = null

    private var btnCancelCategory : FloatingActionButton? = null

    private var carModel: CarModel? = null

    private var categories : MutableList<Category> = MutableList()

    var userActions : UserActions? = null

    init{
        attrs.let {

        }
        etModel = binding.tvModel
        etPrice = binding.tvPrice
        sState = binding.tvState
        etSeats = binding.tvSeats
        etDate = binding.tvRelease
        sCategory = binding.tvCategory
        etCatValue = binding.tvCategoryValue
        lbCatValue = binding.lbCategoryValue
        btnSaveCar = binding.btnDone
        btnSaveCar?.setOnClickListener {
            saveItem()
        }
    }

    private fun saveItem() {
        if(carModel==null){
            carModel = CarModel(
                    0,
                    etSeats?.text.,
                    etPrice?.text,
                    sState?.selectedItemPosition==0,
                    etModel?.text,
                    etDate?.text,
                    etModel?.text,
                    etModel?.text,
            )
        }
        userActions?.saveItem(carModel)
    }

    fun setCategories(categories:List<Category>){
        this.categories.clear()
        this.categories.addAll(categories)
        sCategory?.setText(it.categoryName)
        if(carModel.valueName!=null){
            lbCatValue?.text = it.valueName
            etCatValue?.setText("${it.valueQuantity} ${it.valueQuantityUnit}")
        }else{
            lbCatValue?.visibility = View.GONE
            etCatValue?.visibility = View.GONE
        }
    }

    fun setCar(carModel: CarModel?){
        carModel?.let {
            this.carModel = it
            etModel?.setText(it.model)
            etPrice?.setText("${it.price}")
            sState?.setSelection(
                    getState(it.isNew?:false)
            )
            etSeats?.setText("${it.cantSeats}")
            etDate?.setText(it.dateRelease)
        }
    }

    private fun getState(isNew:Boolean):Int{
        return if(isNew) 0 else 1
    }


    interface UserActions{

        fun saveItem(carModel: CarModel)

    }
}
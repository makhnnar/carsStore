package com.pedrogomez.carsstore.view.editcreate

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pedrogomez.carsstore.R
import com.pedrogomez.carsstore.databinding.ViewEditCreateBinding
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.view.CarModel
import java.util.*
import kotlin.collections.ArrayList

class EditCreateCarView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    var binding : ViewEditCreateBinding = ViewEditCreateBinding.inflate(
            LayoutInflater.from(context),
            this
    )

    private var etModel : AppCompatEditText

    private var etPrice : AppCompatEditText

    private var sState : AppCompatSpinner

    private var etSeats : AppCompatEditText

    private var etDate : AppCompatEditText

    private var sCategory : AppCompatSpinner

    private var etCategory : AppCompatEditText

    private var etCatValue : AppCompatEditText

    private var lbCatValue : AppCompatTextView

    private var btnSaveCar : FloatingActionButton

    private var btnSaveCategory : ImageView

    private var btnCancelCategory : ImageView

    private var carModel: CarModel? = null

    private var categories = ArrayList<Category>()

    var userActions : UserActions? = null

    init{
        attrs.let {

        }
        etModel = binding.etModel
        etPrice = binding.etPrice
        sState = binding.sState
        etSeats = binding.etSeats
        etDate = binding.etRelease
        sCategory = binding.sCategory
        etCategory = binding.etCategory
        etCatValue = binding.tvCategoryValue
        lbCatValue = binding.lbCategoryValue
        btnSaveCar = binding.btnDone
        btnSaveCategory = binding.btnAddCat
        btnCancelCategory = binding.btnDiscardCat
        btnSaveCar.setOnClickListener {
            saveItem()
        }
        btnSaveCategory.setOnClickListener {
            saveCategory()
            hideEtCatAndBtns()
            sCategory.visibility = View.VISIBLE
        }
        btnCancelCategory.setOnClickListener {
            hideEtCatAndBtns()
            sCategory.visibility = View.VISIBLE
        }
        /*sCategory.setOnItemClickListener { parent, view, position, id ->
            if(position<categories.size){
                lbCatValue.text = "${categories[position]}"
            }else{
                sCategory.visibility = View.GONE
                showAddCategory()
            }
        }*/
        val array : Array<String> = resources.getStringArray(R.array.state_car)
        val dataAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this.context,
                R.layout.simple_spinner_item,
                array.toList()
        )
        sState.adapter = dataAdapter
    }

    private fun showAddCategory() {
        btnSaveCategory?.visibility = View.VISIBLE
        btnCancelCategory?.visibility = View.VISIBLE
        etCategory?.visibility = View.VISIBLE
    }

    private fun saveCategory() {
        var category = Category(
                0,
                etCategory?.text.toString(),
                ""
        )
        userActions?.saveCategory(category)
    }

    private fun hideEtCatAndBtns() {
        btnSaveCategory?.visibility = View.GONE
        btnCancelCategory?.visibility = View.GONE
        etCategory?.visibility = View.GONE
    }

    private fun saveItem() {
        val category = categories[sCategory?.selectedItemPosition ?: 0]
        carModel = CarModel(
                0,
                etSeats.text.toString().toInt(),
                etPrice.text.toString().toDouble(),
                sState.selectedItemPosition == 0,
                etModel.text.toString(),
                etDate.text.toString(),
                category.id,
                category.name,
                category.value,
                0,
                etCatValue.text.toString().toDouble(),
                ""
        )
        carModel?.let {
            userActions?.saveItem(it)
        }
    }

    fun setCategories(categories: List<Category>){
        this.categories.clear()
        this.categories.addAll(categories)
        val listTitle : MutableList<String> = categories.map {
            it.name
        }.toMutableList()
        listTitle.add("Add Category")
        val dataAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(
                this.context,
                R.layout.simple_spinner_item,
                listTitle.toList()
        )
        sCategory.adapter = dataAdapter
        carModel?.let {
            lbCatValue.text = it.valueName
            etCatValue.setText("${it.valueQuantity} ${it.valueQuantityUnit}")
            val selected = categories.filter { cat ->
                it.id==cat.id
            }
            var indexInArray = categories.indexOf(selected)
            sCategory.setSelection(indexInArray)
        }
    }

    fun setCar(carModel: CarModel?){
        hideEtCatAndBtns()
        carModel?.let {
            this.carModel = it
            etModel.setText(it.model)
            etPrice.setText("${it.price}")
            sState.setSelection(
                    getState(it.isNew ?: false)
            )
            etSeats.setText("${it.cantSeats}")
            etDate.setText(it.dateRelease)
        }
    }

    private fun getState(isNew: Boolean):Int{
        return if(isNew) 0 else 1
    }

    interface UserActions{

        fun saveItem(carModel: CarModel)

        fun saveCategory(category: Category)

    }
}
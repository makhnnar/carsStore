package com.pedrogomez.carsstore.view.list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.pedrogomez.carsstore.databinding.ViewListBinding
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.view.list.adapter.CarsAdapter
import com.pedrogomez.carsstore.view.list.adapter.ScrollHelper

class ListCarsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle),
    ScrollHelper.OnScrollEvents{

    var binding : ViewListBinding = ViewListBinding.inflate(
            LayoutInflater.from(context),
            this
    )

    var btnUp : FloatingActionButton? = null

    var btnAdd : FloatingActionButton? = null

    var rvItems : RecyclerView? = null

    var loader : ProgressBar? = null

    var itemListActions : ItemListActions? = null

    var userActions : UserActions? = null

    private lateinit var scrollHelper: ScrollHelper

    private lateinit var cAdapter : CarsAdapter

    private lateinit var lManager : LinearLayoutManager

    init{
        attrs.let {

        }
        btnUp = binding.btnToTop
        btnAdd = binding.btnAdd
        rvItems = binding.rvItems
        loader = binding.pbLoader
        initRecyclerView()
    }

    fun setData(items: List<CarModel>){
        cAdapter.submitList(items)
    }

    private fun initRecyclerView() {
        cAdapter = CarsAdapter(
                itemListActions
        )
        lManager = LinearLayoutManager(context)
        rvItems?.apply{
            adapter = cAdapter
            layoutManager = lManager
        }
        scrollHelper = ScrollHelper(
                lManager,
                this
        )
        rvItems?.addOnScrollListener(
                scrollHelper
        )
        btnUp?.setOnClickListener {
            rvItems?.smoothScrollToPosition(0)
        }
        btnAdd?.setOnClickListener {
            userActions?.addNewItem()
        }
    }

    interface UserActions{

        fun addNewItem()

    }

    interface ItemListActions{

        fun goToDetail(carModel:CarModel)

    }

    override fun isOnTop() {
        btnUp?.hide()
    }

    override fun isNotOnTop() {
        btnUp?.show()
    }

}
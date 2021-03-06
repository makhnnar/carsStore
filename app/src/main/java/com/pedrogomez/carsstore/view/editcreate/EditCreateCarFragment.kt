package com.pedrogomez.carsstore.view.editcreate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pedrogomez.carsstore.R
import com.pedrogomez.carsstore.base.FragmentBase
import com.pedrogomez.carsstore.databinding.FragmentEditCreateBinding
import com.pedrogomez.carsstore.domian.db.Category
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.presentation.CarsViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class EditCreateCarFragment : FragmentBase(),
    EditCreateCarView.UserActions{

    private val carsViewModel by lazy {
        requireParentFragment().getViewModel<CarsViewModel>()
    }

    private lateinit var binding: FragmentEditCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentEditCreateBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        binding.editCreateView.userActions = this
        initObservers()
        return view
    }

    private fun initObservers(){
        carsViewModel.getCarToEdit().observe(
                viewLifecycleOwner,
                Observer {
                    binding.editCreateView.setCar(it)
                }
        )
        carsViewModel.categoriesList.observe(
                viewLifecycleOwner,
                Observer {
                    binding.editCreateView.setCategories(it)
                }
        )
    }

    override fun saveItem(carModel: CarModel) {
        hideKeyboard(binding.editCreateView)
        carsViewModel.saveCar(carModel)
        findNavController().navigate(R.id.action_createEditFragment_to_listFragment)
    }

    override fun saveCategory(category: Category) {
        hideKeyboard(binding.editCreateView)
        carsViewModel.addCategory(category)
    }

}
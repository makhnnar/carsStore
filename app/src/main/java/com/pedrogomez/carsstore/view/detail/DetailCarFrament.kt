package com.pedrogomez.carsstore.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.pedrogomez.carsstore.R
import com.pedrogomez.carsstore.base.FragmentBase
import com.pedrogomez.carsstore.databinding.FragmentDetailBinding
import com.pedrogomez.carsstore.domian.view.CarModel
import com.pedrogomez.carsstore.presentation.CarsViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class DetailCarFrament : FragmentBase(),
    DetailCarView.UserActions{

    private val carsViewModel by lazy {
        requireParentFragment().getViewModel<CarsViewModel>()
    }

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentDetailBinding.inflate(
            inflater,
            container,
            false
        )
        val view = binding.root
        binding.detailView.userActions = this
        initObservers()
        return view
    }

    private fun initObservers(){
        carsViewModel.getCarToView().observe(
                viewLifecycleOwner,
                Observer {
                    binding.detailView.setData(it)
                }
        )
    }

    override fun editItem(carModel: CarModel) {
        carsViewModel.setCarToEdit(carModel)
        findNavController().navigate(R.id.action_detailFragment_to_editCreateFragment)
    }

}
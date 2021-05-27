package com.pedrogomez.carsstore.di

import com.pedrogomez.carsstore.presentation.CarsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelInstance = module {
    viewModel {
        CarsViewModel(
            get()
        )
    }
}
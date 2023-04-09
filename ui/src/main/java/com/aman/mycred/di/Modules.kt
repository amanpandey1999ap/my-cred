package com.aman.mycred.di

import com.aman.mycred.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {
  viewModel { HomeViewModel(credUseCases = get()) }
}

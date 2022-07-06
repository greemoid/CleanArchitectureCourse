package com.greemoid.cleanl1.di

import com.greemoid.cleanl1.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getUserName = get(),
            saveUserName = get()
        )
    }
}
package com.greemoid.cleanl1.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName


class MainViewModelFactory(
    private val getUserName: GetUserName,
    private val saveUserName: SaveUserName
) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserName, saveUserName
        ) as T
    }
}

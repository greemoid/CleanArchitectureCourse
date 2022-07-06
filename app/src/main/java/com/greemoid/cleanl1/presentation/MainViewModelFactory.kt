package com.greemoid.cleanl1.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.greemoid.cleanl1.data.repositories.UserRepositoryImpl
import com.greemoid.cleanl1.data.storage.sharedprefs.SharedPrefUserStorage
import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName


class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
    private val getUserName by lazy {  GetUserName(userRepository = userRepository) }
    private val saveUserName by lazy { SaveUserName(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserName, saveUserName
        ) as T
    }
}

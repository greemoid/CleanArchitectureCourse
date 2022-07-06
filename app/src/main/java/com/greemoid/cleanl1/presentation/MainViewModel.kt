package com.greemoid.cleanl1.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName

class MainViewModel(
    private val getUserName: GetUserName,
    private val saveUserName: SaveUserName
) : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result
    fun save(text: String) {
        val param = SaveUserNameParams(name = text)
        _result.value = saveUserName.execute(param = param).toString()
    }

    fun load() {
        val userName = getUserName.execute()
        _result.value = "${userName.firstName} ${userName.lastName}"
    }
}
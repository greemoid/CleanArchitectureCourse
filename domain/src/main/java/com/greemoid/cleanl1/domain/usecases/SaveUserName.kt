package com.greemoid.cleanl1.domain.usecases

import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.repositories.UserRepository

class SaveUserName(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParams) : Boolean {
        userRepository.saveName(param)
        return if (param.name.isNotEmpty()) true else false
    }

}
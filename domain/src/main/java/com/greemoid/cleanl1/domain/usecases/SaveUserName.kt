package com.greemoid.cleanl1.domain.usecases

import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.repositories.UserRepository

class SaveUserName(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParams) : Boolean {

        val oldName = userRepository.getName()
        if (oldName.firstName == param.name) {
            return true
        }

        val result: Boolean = userRepository.saveName(param)
        return result
    }

}
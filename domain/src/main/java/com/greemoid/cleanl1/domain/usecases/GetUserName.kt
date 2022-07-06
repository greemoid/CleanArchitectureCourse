package com.greemoid.cleanl1.domain.usecases

import com.greemoid.cleanl1.domain.models.UserName
import com.greemoid.cleanl1.domain.repositories.UserRepository

class GetUserName(private val userRepository: UserRepository) {

    fun execute() : UserName {

        return userRepository.getName()
    }
}
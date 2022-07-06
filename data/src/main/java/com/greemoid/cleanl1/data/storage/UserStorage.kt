package com.greemoid.cleanl1.data.storage

import com.greemoid.cleanl1.data.storage.models.User

interface UserStorage {

    fun save(user: User) : Boolean

    fun get() : User

}
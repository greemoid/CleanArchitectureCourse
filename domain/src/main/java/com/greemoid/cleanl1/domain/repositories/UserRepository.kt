package com.greemoid.cleanl1.domain.repositories

import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParams) : Boolean

    fun getName() : UserName
}
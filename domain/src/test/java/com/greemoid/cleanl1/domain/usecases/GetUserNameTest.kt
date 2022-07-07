package com.greemoid.cleanl1.domain.usecases

import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.models.UserName
import com.greemoid.cleanl1.domain.repositories.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class GetUserNameTest {

    @Test
    fun `should return the same data as in repository`() {

        val testRepository = TestRepository()
        val useCase = GetUserName(userRepository = testRepository)
        val actual = useCase.execute()
        val excepted = UserName(firstName = "first name", lastName = "last name")
        Assertions.assertEquals(excepted, actual)

    }

}


class TestRepository() : UserRepository {
    override fun saveName(saveParam: SaveUserNameParams): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): UserName {
        return UserName(firstName = "first name", lastName = "last name")
    }

}
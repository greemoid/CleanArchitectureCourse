package com.greemoid.cleanl1.domain.usecases


import com.greemoid.cleanl1.domain.models.UserName
import com.greemoid.cleanl1.domain.repositories.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock



class GetUserNameTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {

        val testUserName = UserName(firstName = "first name", lastName = "last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserName(userRepository = userRepository)
        val actual = useCase.execute()
        val excepted = UserName(firstName = "first name", lastName = "last name")
        Assertions.assertEquals(excepted, actual)

    }

}



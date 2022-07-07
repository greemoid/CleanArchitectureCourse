package com.greemoid.cleanl1.domain.usecases

import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.models.UserName
import com.greemoid.cleanl1.domain.repositories.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameTest {

    private val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(userRepository)
    }

    @Test
    fun `should not save data if contain the same data`() {


        val useCase = SaveUserName(userRepository = userRepository)

        val testUserName = UserName(firstName = "first name", lastName = "last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val testParams = SaveUserNameParams(name = "first name")
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(true, actual)
        Mockito.verify(userRepository, Mockito.never()).saveName(saveParam = any())

    }

    @Test
    fun `should return true if save was successful`() {

        val useCase = SaveUserName(userRepository = userRepository)
        val testParams = SaveUserNameParams(name = "new first name")

        val testUserName = UserName(firstName = "first name", lastName = "last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)
        Mockito.`when`(userRepository.saveName(saveParam = testParams)).thenReturn(true)


        val actual = useCase.execute(testParams)

        Assertions.assertEquals(true, actual)
        Mockito.verify(userRepository, Mockito.times(1)).saveName(saveParam = testParams)
    }

}
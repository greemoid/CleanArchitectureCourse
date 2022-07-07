package com.greemoid.cleanl1.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.greemoid.cleanl1.domain.models.SaveUserNameParams
import com.greemoid.cleanl1.domain.models.UserName
import com.greemoid.cleanl1.domain.usecases.GetUserName
import com.greemoid.cleanl1.domain.usecases.SaveUserName
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class MainViewModelTest {

    private val getUserName = mock<GetUserName>()
    private val saveUserName = mock<SaveUserName>()
    private lateinit var viewModel: MainViewModel

    @AfterEach
    fun afterEach() {
        Mockito.reset(getUserName)
        Mockito.reset(saveUserName)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @BeforeEach
    fun beforeEach() {

        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

        })
    }

    @Test
    fun `should save username and return true`() {
        val testText = "Test user name"
        val testParam = SaveUserNameParams(name = testText)

        viewModel = MainViewModel(
            getUserName, saveUserName
        )

        Mockito.`when`(saveUserName.execute(param = testParam)).thenReturn(true)

        viewModel.save(testText)

        val expected = "true"
        val actual = viewModel.result.value

        Mockito.verify(saveUserName, Mockito.times(1)).execute(param = testParam)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should save username and return false`() {
        val testText = "Test user name"
        val testParam = SaveUserNameParams(name = testText)

        viewModel = MainViewModel(
            getUserName, saveUserName
        )

        Mockito.`when`(saveUserName.execute(param = testParam)).thenReturn(false)

        viewModel.save(testText)

        val expected = "false"
        val actual = viewModel.result.value

        Mockito.verify(saveUserName, Mockito.times(1)).execute(param = testParam)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun `should load username`() {
        val testUserName = UserName(
            firstName = "first name",
            lastName = "last name"
        )

        Mockito.`when`(getUserName.execute()).thenReturn(testUserName)

        viewModel = MainViewModel(getUserName, saveUserName)
        viewModel.load()

        val expected = "${testUserName.firstName} ${testUserName.lastName}"
        val actual = viewModel.result.value

        Assertions.assertEquals(expected, actual)

    }
}
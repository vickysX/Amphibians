package com.example.amphibians.fake

import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.AmphibianViewModel
import com.example.amphibians.ui.AmphibiansUiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AmphibianViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun amphibianViewModel_getAmphibians_verifyAmphibiansUiStateSuccess() {
        runTest {
            val amphibianViewModel = AmphibianViewModel(FakeNetworkAmphibiansRepository())
            assertEquals(
                AmphibiansUiState.Success(FakeDataSource.amphibians),
                amphibianViewModel.amphibiansUiState
            )
        }
    }
}
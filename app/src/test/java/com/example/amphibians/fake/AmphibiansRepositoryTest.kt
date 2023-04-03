package com.example.amphibians.fake

import com.example.amphibians.data.NetworkAmphibiansRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AmphibiansRepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun amphibiansRepository_getAmphibians_verifyAmphibiansList() {
        runTest {
            val repository = NetworkAmphibiansRepository(FakeAmphibiansApiService())
            assertEquals(FakeDataSource.amphibians, repository.getAmphibians())
        }
    }
}
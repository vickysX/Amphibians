package com.example.amphibians.data

import com.example.amphibians.network.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians() : List<Amphibian>
}

class NetworkAmphibiansRepository : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        TODO("Not yet implemented")
    }
}
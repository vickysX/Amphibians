package com.example.amphibians.fake

import com.example.amphibians.network.Amphibian

object FakeDataSource {
    val amphibians = listOf(
        Amphibian(
            name = "Great Basin Spadefoot",
            type = "Toad",
            description = "This toad spends most of its life underground...",
            imgSrc = "Gbs img"
        ),
        Amphibian(
            name = "Roraima Bush Toad",
            type = "Toad",
            description = "This toad is typically found in South America.",
            imgSrc = "Rbt img"
        )
    )
}
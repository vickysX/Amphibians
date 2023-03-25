package com.example.amphibians.ui

import com.example.amphibians.network.Amphibian

sealed interface AmphibiansUiState {
    data class Success(val amphibians : List<Amphibian>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading : AmphibiansUiState
}
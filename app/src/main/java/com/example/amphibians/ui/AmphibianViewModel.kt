package com.example.amphibians.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.NetworkAmphibiansRepository
import kotlinx.coroutines.launch
import okio.IOException

class AmphibianViewModel(
    private val amphibiansRepository: NetworkAmphibiansRepository
) : ViewModel() {

    var amphibiansUiState : AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    private fun getAmphibians() {
        viewModelScope.launch {
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansRepository.getAmphibians())
            } catch (_ : IOException) {
                AmphibiansUiState.Error
            }
        }
    }
}
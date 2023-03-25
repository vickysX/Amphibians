@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.amphibians.R
import com.example.amphibians.screen.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianApp(
    modifier: Modifier = Modifier,
    amphibianViewModel: AmphibianViewModel
) {
    val amphibiansUiState = amphibianViewModel.amphibiansUiState
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                amphibiansUiState = amphibiansUiState
            )
        }
    }
}
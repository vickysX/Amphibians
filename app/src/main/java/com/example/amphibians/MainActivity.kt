package com.example.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.ui.AmphibianApp
import com.example.amphibians.ui.AmphibianViewModel
import com.example.amphibians.ui.theme.AmphibiansTheme

class
MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansTheme {
                val amphibianViewModel: AmphibianViewModel =
                    viewModel(
                        factory = AmphibianViewModel.Factory
                    )
                AmphibianApp(
                    amphibianViewModel = amphibianViewModel
                )

            }
        }
    }
}


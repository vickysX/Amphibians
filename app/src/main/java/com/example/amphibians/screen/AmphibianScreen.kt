package com.example.amphibians.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.network.Amphibian

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Column() {
        
    }
}

@Composable
fun ResultGridScreen(
    modifier: Modifier = Modifier,
    amphibians : List<Amphibian>
) {
    LazyColumn() {
        items(amphibians) {
            AmphibianCard(amphibian = it)
        }
    }
}

@Composable
fun AmphibianCard(
    modifier: Modifier = Modifier,
    amphibian: Amphibian
) {
    Card() {
        Column() {
            Text(
                text = "${amphibian.name} (${amphibian.type})",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = amphibian.description
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.img_description)
            )
        }
    }
}
package com.example.amphibians.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.network.Amphibian
import com.example.amphibians.ui.AmphibiansUiState
import com.example.amphibians.ui.AmphibiansUiState.*
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    amphibiansUiState: AmphibiansUiState,
) {
    when (amphibiansUiState) {
        is Loading -> LoadingErrorScreen(isError = false)
        is Success -> ResultGridScreen(
            amphibians = amphibiansUiState.amphibians
        )
        is Error -> LoadingErrorScreen(isError = true)
    }
}

@Composable
fun LoadingErrorScreen(
    modifier: Modifier = Modifier,
    isError: Boolean
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .wrapContentSize(Alignment.Center)
            .padding(100.dp)
    ) {
        Image(
            imageVector = when {
                isError -> ImageVector
                    .vectorResource(id = R.drawable.frog_face_svgrepo_com_error)
                else -> ImageVector
                    .vectorResource(id = R.drawable.frog_svgrepo_com_loading)
            },
            contentDescription = when {
                isError -> stringResource(id = R.string.error_frog)
                else -> stringResource(id = R.string.loading_frog)
            },
            alignment = Alignment.Center,
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .size(150.dp)
                .padding(24.dp)
        )
        Image(
            imageVector = when {
                isError -> ImageVector.vectorResource(id = R.drawable.error_svgrepo_com)
                else -> ImageVector.vectorResource(id = R.drawable.loading_svgrepo_com)
            },
            contentDescription = when {
                isError -> stringResource(id = R.string.error_frog)
                else -> stringResource(id = R.string.loading_frog)
            },
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .size(150.dp)
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 24.dp
                )
        )
        Text(
            text = when {
                isError -> stringResource(id = R.string.error_frog)
                else -> stringResource(id = R.string.loading_frog)
            },
            fontSize = 24.sp
        )

    }
}


@Composable
fun ResultGridScreen(
    modifier: Modifier = Modifier,
    amphibians: List<Amphibian>
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
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
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "${amphibian.name} (${amphibian.type})",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
            Text(
                text = amphibian.description,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.img_description),
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun LoadingScreenPreview() {
    AmphibiansTheme(useDarkTheme = true) {
        LoadingErrorScreen(isError = false)
    }
}

@Composable
@Preview(showSystemUi = true)
fun ErrorScreenPreview() {
    AmphibiansTheme(useDarkTheme = true) {
        LoadingErrorScreen(isError = true)
    }
}
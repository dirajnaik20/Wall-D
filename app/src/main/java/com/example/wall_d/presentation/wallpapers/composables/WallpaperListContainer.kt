package com.example.wall_d.presentation.wallpapers.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.wall_d.presentation.model.MainResponseUiState
import com.example.wall_d.presentation.model.WallpaperUiState
import com.example.wall_d.presentation.util.LoadImage

@Composable
fun WallpaperListContainer(
    modifier: Modifier,
    mainResponseUiState: MainResponseUiState
) {

    Column(
        modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        LatestWallpaperLazyColumn(
            modifier = modifier,
            mainResponseUiState = mainResponseUiState
        )


    }
}

@Composable
fun LatestWallpaperLazyColumn(
    modifier: Modifier,
    mainResponseUiState: MainResponseUiState
) {

    LazyColumn {
        items(mainResponseUiState.latestWallpapers.take(5).size) { index ->
            LatestWallpaperItem(
                modifier = modifier,
                wallpaperUiState = mainResponseUiState.latestWallpapers[index]
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
        }

    }

}

@Composable
fun LatestWallpaperItem(
    modifier: Modifier,
    wallpaperUiState: WallpaperUiState
) {
    Column {


        ElevatedCard(
            Modifier
                .height(260.dp)
                .padding(2.dp)
                .clip(RoundedCornerShape(2.dp))
                .clickable { },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 50.dp
            ),

        ) {

            LoadImage(url = wallpaperUiState.path)

        }

    }


}


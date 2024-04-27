package com.example.wall_d.presentation.wallpapers.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.example.wall_d.utils.Constants

@Composable
fun WallpaperListContainer(
    modifier: Modifier,
    wallpaperList: List<WallpaperUiState>,
    loadingPop: Boolean,
    onPopularChangeScrollPosition: (Int) -> Unit,
    pagePopular: Int,
    nextPopularPage: () -> Unit,
    onItemClick: (wallpaperUiState: WallpaperUiState) -> Unit
) {


    Column(
        modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        if (loadingPop) {
            LoadingCompose()
        }

        LatestWallpaperLazyColumn(
            modifier = modifier,
            wallpaperList = wallpaperList,
            onPopularChangeScrollPosition = onPopularChangeScrollPosition,
            pagePopular = pagePopular,
            nextPopularPage = nextPopularPage,
            popularLoading = loadingPop,
            onItemClick = onItemClick
        )


    }
}

@Composable
fun LatestWallpaperLazyColumn(
    modifier: Modifier,
    wallpaperList: List<WallpaperUiState>,
    onPopularChangeScrollPosition: (Int) -> Unit,
    pagePopular: Int,
    nextPopularPage: () -> Unit,
    popularLoading: Boolean,
    onItemClick: (wallpaperUiState: WallpaperUiState) -> Unit
) {

    Box(
        modifier = modifier
    ) {

        LazyColumn {
//            items(mainResponseUiState.latestWallpapers.take(5).size) { index ->
//                LatestWallpaperItem(
//                    modifier = modifier,
//                    wallpaperUiState = mainResponseUiState.latestWallpapers[index]
//                )
//                Spacer(
//                    modifier = Modifier
//                        .height(15.dp)
//                )
//            }

            itemsIndexed(items = wallpaperList) { index, item ->

                Log.d("Diraj", "Index: $index")

                onPopularChangeScrollPosition(index)

                if ((index + 1) >= (pagePopular * Constants.PAGE_SIZE) && (!popularLoading)) {
                    nextPopularPage()
                }

                LatestWallpaperItem(
                    modifier = modifier,
                    wallpaperUiState = item,
                    onItemClick = onItemClick
                )
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                )


            }


        }

    }


}

@Composable
fun LatestWallpaperItem(
    modifier: Modifier,
    wallpaperUiState: WallpaperUiState,
    onItemClick: (wallpaperUiState: WallpaperUiState) -> Unit
) {
    Column {


        ElevatedCard(
            Modifier
                .height(260.dp)
                .padding(2.dp)
                .clip(RoundedCornerShape(2.dp))
                .clickable {


                    Log.d("share","wallpaper sent to Shared")
                    onItemClick(wallpaperUiState)


                },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 50.dp
            ),

            ) {

            LoadImage(url = wallpaperUiState.path)

        }

    }


}


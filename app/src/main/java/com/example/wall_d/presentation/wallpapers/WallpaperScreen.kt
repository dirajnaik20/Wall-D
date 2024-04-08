package com.example.wall_d.presentation.wallpapers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wall_d.presentation.wallpapers.composables.WallpaperBottomNavigationContainer
import com.example.wall_d.presentation.wallpapers.composables.WallpaperHeadingContainer
import com.example.wall_d.presentation.wallpapers.composables.WallpaperListContainer
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(true)
@Destination
@Composable
fun WallpaperScreenContainer(
    viewModel: WallpaperViewModel,
    destinationsNavigator: DestinationsNavigator
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        WallpaperHeadingContainer(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.12f)
                .background(Color.Black)
        )
        WallpaperListContainer(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.78f)
                .background(Color.Green)
        )
        WallpaperBottomNavigationContainer(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(0.1f)
                .background(Color.Blue)
        )

    }


}





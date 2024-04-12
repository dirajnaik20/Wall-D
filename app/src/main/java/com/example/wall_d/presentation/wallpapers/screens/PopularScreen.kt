package com.example.wall_d.presentation.wallpapers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import com.example.wall_d.presentation.wallpapers.composables.WallpaperListContainer

@Composable
fun PopularScreen(
    viewModel: WallpaperViewModel
) {
    val mainResponseUiState = viewModel.mainResponseUiState

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

//        Text(
//            text = "Popular Screen",
//            fontSize = 32.sp,
//            fontFamily = fontFamilyBungee
//        )

        WallpaperListContainer(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color(android.graphics.Color.parseColor("#0D0E0E"))),
            mainResponseUiState = mainResponseUiState.value
        )

    }

}
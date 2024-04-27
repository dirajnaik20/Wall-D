package com.example.wall_d.presentation.wallpapers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.wall_d.R
import com.example.wall_d.presentation.SharedViewModel
import com.example.wall_d.presentation.model.WallpaperUiState
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import com.example.wall_d.presentation.wallpapers.composables.WallpaperListContainer

@Composable
fun PopularScreen(
    viewModel: WallpaperViewModel,
    sharedViewModel: SharedViewModel,
    onItemClick: (wallpaperUiState: WallpaperUiState) -> Unit
) {
    val popList = viewModel.popList
    val loadingPop = viewModel.loadingPopState

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
                .background(colorResource(id = R.color.listBackground)),
            wallpaperList = popList.value,
            loadingPop=loadingPop.value,
            onPopularChangeScrollPosition = {
                viewModel.onChangePopularScrollPosition(it)
            },
            pagePopular = viewModel.pagePopular.value,
            nextPopularPage = {
                viewModel.getNextPopularPage()
            },
            onItemClick=onItemClick
        )

    }

}
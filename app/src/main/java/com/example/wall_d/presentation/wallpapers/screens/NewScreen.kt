package com.example.wall_d.presentation.wallpapers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.wall_d.R
import com.example.wall_d.presentation.model.WallpaperUiState
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import com.example.wall_d.presentation.wallpapers.composables.WallpaperListContainer

@Composable
fun NewScreen(

    viewModel: WallpaperViewModel,
    onItemClick: (wallpaperUiState: WallpaperUiState) -> Unit



) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        val newList = viewModel.newList
        val loadingNew = viewModel.loadingNewState

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

//            viewModel.initialNewAPICall()




            WallpaperListContainer(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(colorResource(id = R.color.listBackground)),
                wallpaperList = newList.value,
                loadingPop=loadingNew.value,
                onPopularChangeScrollPosition = {
                    viewModel.onChangeNewScrollPosition(it)
                },
                pagePopular = viewModel.pageNew.value,
                nextPopularPage = {
                    viewModel.getNextNewPage()
                },
                onItemClick= onItemClick
            )


        }
    }

}
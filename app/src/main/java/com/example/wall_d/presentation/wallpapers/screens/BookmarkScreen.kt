package com.example.wall_d.presentation.wallpapers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.wall_d.R
import com.example.wall_d.data.local_data.BookmarkWallpaper
import com.example.wall_d.presentation.util.LoadImage

@Composable
fun BookmarkScreen(
    getSavedList: () -> LiveData<List<BookmarkWallpaper>>,
    deleteWallpaper: (BookmarkWallpaper) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.listBackground))
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {

        val savedList by getSavedList().observeAsState()

        savedList?.let { BookmarkWallpaperContainer(it, deleteWallpaper = deleteWallpaper) }

    }

}

@Composable
fun BookmarkWallpaperContainer(
    savedList: List<BookmarkWallpaper>,
    deleteWallpaper: (BookmarkWallpaper) -> Unit
) {

    LazyColumn {
        items(savedList.size) { index ->

            SavedWallpaperListItem(
                savedList[index],
                deleteWallpaper = deleteWallpaper
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )

        }
    }

}

@Composable
fun SavedWallpaperListItem(
    bookmarkWallpaper: BookmarkWallpaper,
    deleteWallpaper: (BookmarkWallpaper) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.listBackground)),
        contentAlignment = Alignment.Center,
    ) {


        ElevatedCard(
            Modifier
                .height(260.dp)
                .padding(2.dp)
                .clip(RoundedCornerShape(2.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 50.dp
            ),

            ) {

            LoadImage(url = bookmarkWallpaper.path)

        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .size(45.dp)
                .background(colorResource(R.color.pastelPrimary).copy(alpha = 0.4f))
                .align(Alignment.TopEnd)
                .clickable {
                           deleteWallpaper(bookmarkWallpaper)
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "back-button",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}


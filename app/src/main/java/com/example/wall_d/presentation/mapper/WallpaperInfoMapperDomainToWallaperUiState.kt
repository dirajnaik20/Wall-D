package com.example.wall_d.presentation.mapper

import com.example.wall_d.data.local_data.BookmarkWallpaper
import com.example.wall_d.domain.model.MainResponseInfo
import com.example.wall_d.domain.model.WallpaperInfo
import com.example.wall_d.presentation.model.MainResponseUiState
import com.example.wall_d.presentation.model.WallpaperUiState

fun MainResponseInfo.toMainResponseUiState(): MainResponseUiState {
    return MainResponseUiState(
        latestWallpapers = this.wallpapers.map { it.toWallpaperUiState() }
    )
}

fun WallpaperInfo.toWallpaperUiState(): WallpaperUiState {

    return WallpaperUiState(
        id = this.id,
        createdAt = this.createdAt,
        fileSize = this.fileSize,
        fileType = this.fileType,
        resolution = this.resolution,
        url = this.url,
        path=this.path,
        views = this.views

    )

}

fun WallpaperUiState.toBookMarkWallpaper():BookmarkWallpaper{
    return BookmarkWallpaper(
        id = this.id,
        path=this.path,
//        createdAt = this.createdAt,
//        fileSize = this.fileSize,
//        fileType = this.fileType,
//        resolution = this.resolution,
//        url = this.url,
//        views = this.views

    )
}
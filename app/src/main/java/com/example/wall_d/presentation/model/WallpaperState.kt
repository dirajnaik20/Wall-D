package com.example.wall_d.presentation.model

data class MainResponseUiState(
    val latestWallpapers : List<WallpaperUiState>
)

data class WallpaperUiState(
    val id : String,
    val createdAt: String,
    val fileSize: Int,
    val fileType: String,
    val resolution: String,
    val url: String,
    val path:String,
    val views: Int
)
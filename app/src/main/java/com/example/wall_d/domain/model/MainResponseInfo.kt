package com.example.wall_d.domain.model

data class MainResponseInfo(
   val wallpapers:List<WallpaperInfo>
)

data class  WallpaperInfo(
    val id : String,
    val createdAt: String,
    val fileSize: Int,
    val fileType: String,
    val resolution: String,
    val url: String,
    val views: Int
)
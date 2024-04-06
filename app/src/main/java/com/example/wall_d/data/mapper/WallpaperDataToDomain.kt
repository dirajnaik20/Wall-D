package com.example.wall_d.data.mapper

import com.example.wall_d.data.Dto.MainResponseDTO
import com.example.wall_d.data.Dto.WallpaperDTO
import com.example.wall_d.domain.model.MainResponseInfo
import com.example.wall_d.domain.model.WallpaperInfo

fun MainResponseDTO.toMainResponseInfo(): MainResponseInfo {
    return MainResponseInfo(
        wallpapers = wallpaperDTO.toWallpaperInfo()
    )
}

fun List<WallpaperDTO>.toWallpaperInfo(): List<WallpaperInfo> {
    return this
        .map {
            WallpaperInfo(
                id = it.id,
                createdAt = it.createdAt,
                fileSize = it.fileSize,
                fileType = it.fileType,
                resolution = it.resolution,
                url = it.url,
                views = it.views
            )
        }
        .toList()
}
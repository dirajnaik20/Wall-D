package com.example.wall_d.domain.repository


import com.example.wall_d.data.Dto.WallpaperDTO
import com.example.wall_d.domain.model.MainResponseInfo
import com.example.wall_d.utils.Constants
import com.example.wall_d.utils.Resource

interface WallpaperRepository {

    suspend fun getPopularWallpaperList(
        page: Int

    ): Resource<MainResponseInfo>

    suspend fun getNewWallpaperList(
        page: Int
    ): Resource<MainResponseInfo>


}
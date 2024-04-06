package com.example.wall_d.domain.repository


import com.example.wall_d.data.Dto.WallpaperDTO
import com.example.wall_d.domain.model.MainResponseInfo
import com.example.wall_d.utils.Resource

interface WallpaperRepository {

    suspend fun getWallpaperList(
        query: String,
        sorting: String,
        page: Int

    ): Resource<MainResponseInfo>


}
package com.example.wall_d.data

import com.example.wall_d.data.Dto.MainResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WallHeavenApi {

    companion object {
        const val BASE_URL_WALLPAPER = "https://wallhaven.cc/"
        const val WALLPAPER_API_KEY = "J2jFbl2lIz9XzQfJTQKPZVVAx1f3IJBV"

    }

    @GET("/api/v1/search")
    suspend fun getImageList(
        @Query("q") query: String,
        @Query("sorting") sorting: String,
        @Query("page") page: Int,

    ): MainResponseDTO
}
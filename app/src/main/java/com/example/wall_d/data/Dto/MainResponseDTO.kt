package com.example.wall_d.data.Dto


import com.google.gson.annotations.SerializedName

data class MainResponseDTO(
    @SerializedName("data")
    val wallpaperDTO: List<WallpaperDTO>,
    @SerializedName("meta")
    val meta: Meta
)

data class WallpaperDTO(
    @SerializedName("category")
    val category: String,
    @SerializedName("colors")
    val colors: List<String>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("dimension_x")
    val dimensionX: Int,
    @SerializedName("dimension_y")
    val dimensionY: Int,
    @SerializedName("favorites")
    val favorites: Int,
    @SerializedName("file_size")
    val fileSize: Int,
    @SerializedName("file_type")
    val fileType: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("purity")
    val purity: String,
    @SerializedName("ratio")
    val ratio: String,
    @SerializedName("resolution")
    val resolution: String,
    @SerializedName("short_url")
    val shortUrl: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("thumbs")
    val thumbs: Thumbs,
    @SerializedName("url")
    val url: String,
    @SerializedName("views")
    val views: Int
)

data class Meta(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("per_page")
    val perPage: String,
    @SerializedName("query")
    val query: Any,
    @SerializedName("seed")
    val seed: Any,
    @SerializedName("total")
    val total: Int
)

data class Thumbs(
    @SerializedName("large")
    val large: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("small")
    val small: String
)
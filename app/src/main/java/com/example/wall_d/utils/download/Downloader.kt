package com.example.wall_d.utils.download

interface Downloader {

    fun downloadFile(
        id: String,
        url: String

    ): Long
}
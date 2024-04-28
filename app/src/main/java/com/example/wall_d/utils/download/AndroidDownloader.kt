package com.example.wall_d.utils.download


import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class AndroidDownloader(
    private val context: Context
) : Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)
    override fun downloadFile(
        id: String,
        url: String
    ): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("image/jpeg")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("${id}.jpeg")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "${id}.jpeg")

        return downloadManager.enqueue(request)
    }


}
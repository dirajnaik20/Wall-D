package com.example.wall_d.utils

import android.content.Context
import android.net.ConnectivityManager

fun Context.isConnectedToNetwork(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    return manager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
}
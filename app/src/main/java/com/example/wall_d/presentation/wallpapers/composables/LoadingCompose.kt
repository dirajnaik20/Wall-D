package com.example.wall_d.presentation.wallpapers.composables

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.wall_d.R

@Composable
fun LoadingCompose(
) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Log.d("loading", "In loading compose")

        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = colorResource(id = R.color.titleColor),
            strokeWidth = 10.dp,
        )

    }

}
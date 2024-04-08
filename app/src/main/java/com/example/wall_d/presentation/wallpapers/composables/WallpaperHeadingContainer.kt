package com.example.wall_d.presentation.wallpapers.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wall_d.R
import com.example.wall_d.ui.theme.fontFamilyBungee
import com.example.wall_d.ui.theme.textStyle

@Composable
fun WallpaperHeadingContainer(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp,30.dp,0.dp,0.dp)
    ) {
        Text(
            text = "Wall-D.",
            fontSize = 35.sp,
            color = colorResource(id = R.color.titleColor),
            fontFamily = fontFamilyBungee,
            style = textStyle
        )
    }

}
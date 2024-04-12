package com.example.wall_d.presentation.wallpapers.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.example.wall_d.R
import com.example.wall_d.ui.theme.fontFamilyBungee
import com.example.wall_d.ui.theme.textStyle

@Composable
fun TopAppBarHeading(){

    Text(
        text = "Wall-D.",
        fontSize = 35.sp,
        color = colorResource(id = R.color.titleColor),
        fontFamily = fontFamilyBungee,
        style = textStyle
    )

}
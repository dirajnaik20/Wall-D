package com.example.wall_d.presentation.wallpapers.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.wall_d.ui.theme.fontFamilyBungee

@Composable
fun SettingsScreen(

) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "Setting Screen",
            fontSize = 32.sp,
            fontFamily = fontFamilyBungee
        )

    }

}
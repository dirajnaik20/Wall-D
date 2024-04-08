package com.example.wall_d.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.wall_d.presentation.wallpapers.NavGraphs
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import com.example.wall_d.ui.theme.WallDTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            WallDTheme {
                AppNavigation(this@MainActivity)
            }
        }
    }
}

@Composable
private fun AppNavigation(activity: ComponentActivity) {

    DestinationsNavHost(
        navGraph = NavGraphs.root,
        dependenciesContainerBuilder = {
            dependency(
                hiltViewModel<WallpaperViewModel>(activity)

            )

        }
    )

}
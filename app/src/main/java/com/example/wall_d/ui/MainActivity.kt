package com.example.wall_d.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.wall_d.presentation.SharedViewModel
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import com.example.wall_d.presentation.wallpapers.bottom_navigations.AppBottomBarNavigation
import com.example.wall_d.ui.theme.WallDTheme
import com.example.wall_d.utils.download.AndroidDownloader
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModel: WallpaperViewModel

    @Inject
    lateinit var sharedViewModel: SharedViewModel






    override fun onCreate(savedInstanceState: Bundle?) {

        val downloader = AndroidDownloader(this)

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
//                AppNavigation(this@MainActivity)
                AppBottomBarNavigation(viewModel,sharedViewModel,downloader)
            }
        }
    }
}

//@Composable
//private fun AppNavigation(activity: ComponentActivity) {
//
//    DestinationsNavHost(
//        navGraph = NavGraphs.root,
//        dependenciesContainerBuilder = {
//            dependency(
//                hiltViewModel<WallpaperViewModel>(activity)
//
//            )
//
//        }
//    )
//
//}
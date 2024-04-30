package com.example.wall_d.presentation.wallpapers.bottom_navigations

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wall_d.R
import com.example.wall_d.presentation.BookMarkViewModel
import com.example.wall_d.presentation.SharedViewModel
import com.example.wall_d.presentation.mapper.toBookMarkWallpaper
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import com.example.wall_d.presentation.wallpapers.composables.TopAppBarHeading
import com.example.wall_d.presentation.wallpapers.screens.BookmarkScreen
import com.example.wall_d.presentation.wallpapers.screens.DetailsScreen
import com.example.wall_d.presentation.wallpapers.screens.NewScreen
import com.example.wall_d.presentation.wallpapers.screens.PopularScreen
import com.example.wall_d.presentation.wallpapers.screens.SettingsScreen
import com.example.wall_d.utils.download.AndroidDownloader
import androidx.compose.runtime.livedata.observeAsState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomBarNavigation(
    viewModel: WallpaperViewModel,
    sharedViewModel: SharedViewModel,
    downloader: AndroidDownloader,
    bookMarkViewModel: BookMarkViewModel

) {

    val navController = rememberNavController()

    var showBottomBar by rememberSaveable {

        mutableStateOf(true)

    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        Screens.DetailsScreen.name -> false // on this screen bottom bar should be hidden
        else -> true // in all other cases show bottom bar
    }

    Scaffold(
        topBar = {
            if (showBottomBar) {
                TopAppBar(
                    title = {
                        TopAppBarHeading()
                    },
                    colors = topAppBarColors(
                        containerColor = colorResource(R.color.listBackground),
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                )

            }
        },
        bottomBar = {

            if (showBottomBar) {

                BottomAppBar(
                    containerColor = Color.Black
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    listOfNavItems.forEach { navItem ->
                        if (currentDestination != null) {
                            NavigationBarItem(
                                selected = currentDestination.hierarchy.any {
                                    it.route == navItem.route
                                },
                                onClick = {
                                    navController.navigate(navItem.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = navItem.icon),
                                        contentDescription = "",
                                        tint = colorResource(id = R.color.aquamarine)
                                    )
                                },
                                label = {
                                    Text(
                                        text = navItem.label,
                                        color = colorResource(id = R.color.titleColor)
                                    )
                                }

                            )
                        }

                    }
                }

            }


        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.PopularScreen.name,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = Screens.PopularScreen.name) {
                PopularScreen(
                    viewModel = viewModel,
                    sharedViewModel = sharedViewModel,
                    onItemClick = {
                        sharedViewModel.updateData(it)
                        navController.navigate(Screens.DetailsScreen.name)
                    }
                )
            }

            composable(route = Screens.NewScreen.name) {
                NewScreen(viewModel = viewModel,
                    onItemClick = {
                        sharedViewModel.updateData(it)
                        navController.navigate(Screens.DetailsScreen.name)
                    }
                )
            }

            composable(route = Screens.BookmarkScreen.name) {
                BookmarkScreen(
                    getSavedList = {

                        return@BookmarkScreen bookMarkViewModel.savedWallpaperList

                    },
                    deleteWallpaper = {
                        bookMarkViewModel.deleteWallpaper(it)

                    }
                )
            }

            composable(route = Screens.SettingScreen.name) {
                SettingsScreen()
            }
            composable(route = Screens.DetailsScreen.name) {
                DetailsScreen(
                    sharedViewModel,
                    onBackButtonClicked = {
                        navController.popBackStack()
                    },
                    download = { str1, str2 ->
                        downloader.downloadFile(str1, str2)
                    },
                    saveWallpaper = {
                        bookMarkViewModel.saveWallpaper(it.toBookMarkWallpaper())

                    },
                    isBookMark = {
                        return@DetailsScreen bookMarkViewModel.isBookMark.value
                    },
                    updateIsBookMark = {
                        bookMarkViewModel.updateIsBookMark()
                    },
                    deleteWallpaper = {
                        bookMarkViewModel.deleteWallpaper(it.toBookMarkWallpaper())
                    }
                )
            }

        }


    }

}
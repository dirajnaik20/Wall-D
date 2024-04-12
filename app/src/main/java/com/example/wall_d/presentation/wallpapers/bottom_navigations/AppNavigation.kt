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
import androidx.compose.runtime.remember
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
import com.example.wall_d.presentation.wallpapers.WallpaperViewModel
import com.example.wall_d.presentation.wallpapers.composables.TopAppBarHeading
import com.example.wall_d.presentation.wallpapers.screens.BookmarkScreen
import com.example.wall_d.presentation.wallpapers.screens.NewScreen
import com.example.wall_d.presentation.wallpapers.screens.PopularScreen
import com.example.wall_d.presentation.wallpapers.screens.SettingsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomBarNavigation(viewModel: WallpaperViewModel) {

    val navController = rememberNavController()
    val _isLabelVisible = remember {
        mutableStateOf(false)
    }
    var isLabelVisible = _isLabelVisible

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TopAppBarHeading()
                },
                colors = topAppBarColors(
                    containerColor = colorResource(R.color.listBackground),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black,
                contentColor = Color.Red,

                ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach { navItem ->
                    if (currentDestination != null) {
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any {
                                it.route == navItem.route
                            } == true,
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
                                    isLabelVisible.value = !isLabelVisible.value
                            }

                        )
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
                PopularScreen(viewModel = viewModel)
            }

            composable(route = Screens.NewScreen.name) {
                NewScreen()
            }

            composable(route = Screens.BookmarkScreen.name) {
                BookmarkScreen()
            }

            composable(route = Screens.SettingScreen.name) {
                SettingsScreen()
            }

        }

    }

}
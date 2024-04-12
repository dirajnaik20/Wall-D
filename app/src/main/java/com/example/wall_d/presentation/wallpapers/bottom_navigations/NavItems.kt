package com.example.wall_d.presentation.wallpapers.bottom_navigations

import android.graphics.drawable.VectorDrawable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.wall_d.R

data class NavItem(
    val label: String,
    val icon: Int,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Popular",
        icon =R.drawable.ic_outline_trending_u_24px,
        route = Screens.PopularScreen.name
    ),
    NavItem(
        label = "New",
        icon = R.drawable.new_ic,
        route = Screens.NewScreen.name
    ),
    NavItem(
        label = "Bookmark",
        icon = R.drawable.ic_bookmark_border,
        route = Screens.BookmarkScreen.name
    ),
    NavItem(
        label = "Settings",
        icon = R.drawable.ic_settings,
        route = Screens.SettingScreen.name
    )

)

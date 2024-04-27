package com.example.wall_d.presentation.wallpapers.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wall_d.R
import com.example.wall_d.presentation.SharedViewModel
import com.example.wall_d.presentation.util.LoadImage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    sharedViewModel: SharedViewModel,
    onBackButtonClicked: () -> Unit
) {
    val onClickedWallpaperItem = sharedViewModel.onClickedWallpaperItem

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.listBackground))
            .clickable { showBottomSheet = true },
        contentAlignment = Alignment.Center,
    ) {
        LoadImage(url = onClickedWallpaperItem.value.path)

//        Button(
//            onClick = {
//                onBackButtonClicked()
//            },
//            modifier = Modifier
//                .align(Alignment.TopStart)
//                .padding(20.dp)
//                .background(Color.Transparent)
//
//        ) {
//            Icon(
//                painterResource(
//                    id = R.drawable.ic_left_back_arrow
//                ),
//                contentDescription = "",
//                modifier = Modifier
//                    .size(20.dp)
//                ,
//                tint = colorResource(id = R.color.titleColor)
//            )
//
//        }

//        Button(
//            onClick = { /*TODO*/ },
//            modifier = Modifier
//                .align(Alignment.TopEnd)
//                .padding(20.dp)
//
//        ) {
//            Text(text = "BACK")
//
//        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .size(45.dp)
                .background(colorResource(R.color.pastelPrimary).copy(alpha = 0.4f))
                .clickable {
                    onBackButtonClicked()
                }
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "back-button",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }

        Box(
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .size(45.dp)
                .background(colorResource(R.color.pastelPrimary).copy(alpha = 0.4f))
                .clickable { }
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark_border),
                contentDescription = "bookmark-button",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }



        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                containerColor = colorResource(id = R.color.pastelPrimary).copy(alpha = 0.4f),
                contentColor = Color.White
            ) {
                // Sheet content
//                Button(onClick = {
//                    scope.launch { sheetState.hide() }.invokeOnCompletion {
//                        if (!sheetState.isVisible) {
//                            showBottomSheet = false
//                        }
//                    }
//                }) {
//                    Text("Hide bottom sheet")
//                }
                Column(
                    modifier = Modifier
                        .padding(5.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {

                    RowWithIcon(
                        text = onClickedWallpaperItem.value.fileType,
                        icon = R.drawable.ic_file_type_info,
                        contentDescription = "file-type"
                    )

                    RowWithIcon(
                        text = ("${onClickedWallpaperItem.value.fileSize / 10000} MB"),
                        icon = R.drawable.photo_size,
                        contentDescription = "file-size"
                    )

                    RowWithIcon(
                        text = onClickedWallpaperItem.value.createdAt,
                        icon = R.drawable.ic_date,
                        contentDescription = "created-at"
                    )

                    RowWithIcon(
                        text = onClickedWallpaperItem.value.resolution,
                        icon = R.drawable.ic_resolution,
                        contentDescription = "created-at"
                    )


//                    Row {
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_file_type_info),
//                            contentDescription = "file-type",
//                            modifier = Modifier
//                                .size(20.dp)
//                        )
//
//                        Text(text = "File Type: ${onClickedWallpaperItem.value.fileType}")
//
//                    }
//
//                    Text(text = "File Size: ${onClickedWallpaperItem.value.fileSize.toInt() / 10000} MB")
//                    Text(text = "Created At: ${onClickedWallpaperItem.value.createdAt}")
                }
            }
        }

    }

}

@Composable
fun RowWithIcon(
    text: String,
    icon: Int,
    contentDescription: String
) {
    Spacer(modifier = Modifier.width(20.dp))

    Row(

    ) {
        Icon(
            painterResource(id = icon),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }

}

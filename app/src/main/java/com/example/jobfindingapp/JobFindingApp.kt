@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfindingapp.data.DataSource
import com.example.jobfindingapp.ui.screens.details.DetailsScreen
import com.example.jobfindingapp.ui.screens.home.HomeScreen
import com.example.jobfindingapp.ui.theme.LightPink
import com.example.jobfindingapp.utils.AppBarAction
import com.example.jobfindingapp.utils.BottomBarItem
import com.example.jobfindingapp.utils.JobFindingScreens

@Composable
fun JobFindingApp() {
    var currentScreen by remember {
        mutableStateOf(JobFindingScreens.Home)
    }
    var job by remember {
        mutableStateOf(DataSource.jobsList.first())
    }

    when (currentScreen) {
        JobFindingScreens.Home -> HomeScreen(
            onApplyButtonClicked = {
                newJob ->
                currentScreen = JobFindingScreens.Details
                job = newJob
            }
        )

        JobFindingScreens.Details -> DetailsScreen(
            job = job,
            onBackButtonClicked = { currentScreen = JobFindingScreens.Home }
        )
    }
}

@Composable
fun JobFindingAppBar(
    title: String,
    isHomeScreen: Boolean,
    appBarAction: AppBarAction,
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit = {},
    @DrawableRes profileImage: Int = R.drawable.img_profile,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
            )
        },
        navigationIcon = {
            if (isHomeScreen) {
                IconButton(onClick = { }) {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_menu_icon), null)
                }
            } else {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(imageVector = Icons.Filled.ArrowBack, null)
                }
            }
        },
        actions = {
            when (appBarAction) {
                AppBarAction.None -> {}
                AppBarAction.Profile -> {
                    Image(
                        painter = painterResource(profileImage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                    )
                }

                AppBarAction.Bookmark -> {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_bookmark_icon),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .size(25.dp)
                                .clip(CircleShape)
                        )
                    }
                }
            }
        },
        modifier = modifier,
        windowInsets = WindowInsets(left = 20.dp, right = 20.dp),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    )
}

@Composable
fun JobFindingBottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.White,
    ) {
        var selectedPage: BottomBarItem by remember {
            mutableStateOf(BottomBarItem.Home)
        }

        JobFindingNavigationBarItem(
            selected = selectedPage == BottomBarItem.Home,
            onClick = { selectedPage = BottomBarItem.Home },
            icon = ImageVector.vectorResource(id = R.drawable.ic_home_icon),
        )
        JobFindingNavigationBarItem(
            selected = selectedPage == BottomBarItem.Bookmark,
            onClick = { selectedPage = BottomBarItem.Bookmark },
            icon = ImageVector.vectorResource(id = R.drawable.ic_bookmark_icon),
        )
        JobFindingNavigationBarItem(
            selected = selectedPage == BottomBarItem.Chat,
            onClick = { selectedPage = BottomBarItem.Chat },
            icon = ImageVector.vectorResource(id = R.drawable.ic_message_icon),
        )
        JobFindingNavigationBarItem(
            selected = selectedPage == BottomBarItem.Profile,
            onClick = { selectedPage = BottomBarItem.Profile },
            icon = ImageVector.vectorResource(id = R.drawable.ic_profile_icon),
        )
    }
}

@Composable
fun RowScope.JobFindingNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    NavigationBarItem(
        selected = false,
        onClick = onClick,
        modifier = modifier,
        icon = {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                if (selected) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .height(4.dp)
                            .width(60.dp)
                            .background(LightPink)
                    )
                }
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (selected) LightPink else Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun JobFindingAppBarPreview() {
    Scaffold(
        topBar = {
            JobFindingAppBar(
                title = "Hii, Jay",
                isHomeScreen = true,
                appBarAction = AppBarAction.Profile,
            )
        },
        bottomBar = { JobFindingBottomBar() },
    ) {
        val a = it
    }
}

//@Preview(showBackground = true)
@Composable
fun NavigationBarItemPreview() {
//    NavigationBarItem()
}

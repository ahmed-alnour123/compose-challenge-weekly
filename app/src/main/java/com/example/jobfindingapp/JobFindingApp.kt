package com.example.jobfindingapp

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfindingapp.ui.screens.home.HomeScreen

@Composable
fun JobFindingApp() {
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobFindingAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = { Text(text = "hii, Jay") },
        modifier = modifier,
        navigationIcon = {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.icon_menu), null)
        },
        actions = {
            AppBarAvatar(R.drawable.ic_launcher_foreground)
        },
    )
}

@Composable
fun AppBarAvatar(@DrawableRes avatarDrawable: Int) {
    Box(contentAlignment = Alignment.Center) {
        Spacer(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Black),
        )
        Spacer(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.White),
        )
        Image(
            painter = painterResource(avatarDrawable),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Green)
        )
    }
}

@Composable
fun JobFindingBottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
    ) {
        val selectedPage: String = "bookmark"

        JobFindingNavigationBarItem(
            selected = selectedPage == "home",
            onClick = { /*TODO*/ },
            icon = ImageVector.vectorResource(id = R.drawable.icon_home),
        )
        JobFindingNavigationBarItem(
            selected = selectedPage == "bookmark",
            onClick = { /*TODO*/ },
            icon = ImageVector.vectorResource(id = R.drawable.icon_bookmark),
        )
        JobFindingNavigationBarItem(
            selected = selectedPage == "chat",
            onClick = { /*TODO*/ },
            icon = ImageVector.vectorResource(id = R.drawable.icon_message),
        )
        JobFindingNavigationBarItem(
            selected = selectedPage == "profile",
            onClick = { /*TODO*/ },
            icon = ImageVector.vectorResource(id = R.drawable.icon_profile),
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
        modifier = modifier,//.weight(1f),
        icon = {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
//                    .background(Color.Green)
            ) {
                if (selected) {
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(60.dp)
                            .background(Color.Magenta)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (selected) Color.Magenta else Color.Black,
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun JobFindingAppBarPreview() {
    Scaffold(
        topBar = { JobFindingAppBar() },
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

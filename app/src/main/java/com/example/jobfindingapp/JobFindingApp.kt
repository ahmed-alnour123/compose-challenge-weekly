package com.example.jobfindingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.example.jobfindingapp.ui.screens.home.HomeScreen
import com.example.jobfindingapp.ui.theme.LightPink
import com.example.jobfindingapp.utils.BottomBarItem

@Composable
fun JobFindingApp() {
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobFindingAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "hii, Jay",
                style = MaterialTheme.typography.titleLarge,
            )
        },
        modifier = modifier
            .fillMaxWidth(),
//            .padding(horizontal = 30.dp),
        navigationIcon = {
            IconButton(modifier = Modifier, onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_menu_icon),
                    null,
//                    modifier = Modifier.fillMaxSize()
                )
            }
        },
        actions = {
            Image(
//                painter = painterResource(R.drawable.image_profile),
                painter = painterResource(R.drawable.img_profile),
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
            )
        },
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
                            .height(4.dp)
                            .width(60.dp)
                            .background(LightPink)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (selected) LightPink else Color.Black,
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

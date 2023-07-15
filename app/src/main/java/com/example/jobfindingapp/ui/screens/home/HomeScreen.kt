package com.example.jobfindingapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.HourglassFull
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobfindingapp.JobFindingAppBar
import com.example.jobfindingapp.JobFindingBottomBar
import com.example.jobfindingapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { JobFindingAppBar() },
        bottomBar = { JobFindingBottomBar() },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Your skill is required for many jobs")
            Box {
                Image(
                    painter = painterResource(id = R.drawable.home_screen_image),
                    contentDescription = null,
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(imageVector = Icons.Filled.Search, null) },
                    label = { Text("Search any job") }
                )
            }
            Row {
                Text("Based on your skills")
                Text(
                    "view all",
                    modifier = Modifier.clickable { },
                )
            }
            LazyRow {
                item {
                    JobCard()
                }
                item {
                    JobCard()
                }
            }
        }
    }
}

@Composable
fun JobCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
            )
            IconText(
                text = "4.5",
                icon = Icons.Filled.Star,
            )
        }
        Text("Swift Developer")
        Text("Delhi, New Delhi")
        Row {
            IconText(
                text = "2 days ago",
                icon = Icons.Filled.AccessTime,
            )
            IconText(
                text = "Full time",
                icon = Icons.Filled.HourglassFull,
            )
        }
        Row {
            Button(onClick = {}) {
                Text(text = "Apply now")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Outlined.BookmarkBorder,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun IconText(text: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
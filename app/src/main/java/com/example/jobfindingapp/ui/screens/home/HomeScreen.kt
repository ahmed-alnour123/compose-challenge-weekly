package com.example.jobfindingapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        val horizontalPadding = 35.dp
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                "Your skill is required for many jobs",
                style = TextStyle(
                    fontSize = 28.sp,
                    lineHeight = 38.sp,
//                    fontFamily = FontFamily(Font(R.font.poppins)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF1A1A1A),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding),
            )
            Spacer(modifier = Modifier.height(27.dp))
            Box(
                modifier = Modifier.padding(horizontal = horizontalPadding),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_screen_image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(358 / 282f)
                        .align(Alignment.Center),
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(imageVector = Icons.Filled.Search, null) },
                    label = {
                        Text(
                            "Search any job",
                            style = TextStyle(
                                fontSize = 16.sp,
//                                fontFamily = FontFamily(Font(R.font.lato)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                            ),
                        )
                    },
                    modifier = Modifier
                        .size(247.dp, 65.dp)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(27.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "Based on your skills",
                    style = TextStyle(
                        fontSize = 20.sp,
//                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF1A1A1A),
                    )
                )
                Text(
                    "view all",
                    style = TextStyle(
                        fontSize = 14.sp,
//                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFFCCAFFF),
                    ),
                    modifier = Modifier.clickable { },
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                for (i in 1..5) {
                    item {
                        JobCard()
                    }
                }
            }
        }
    }
}

@Composable
fun JobCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.size(227.dp, 234.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Row(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(56.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
                IconText(
                    text = "4.5",
                    icon = Icons.Filled.Star,
                    textStyle = TextStyle(
                        fontSize = 16.sp,
//                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0x661A1A1A),
                    ),
                    iconSize = 16.dp,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    "Swift Developer",
                    style = TextStyle(
                        fontSize = 16.sp,
//                    fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF1A1A1A),
                    ),
                )
                Text(
                    "Delhi, New Delhi",
                    style = TextStyle(
                        fontSize = 14.sp,
//                    fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0x661A1A1A),
                    ),
                )
                Row {
                    IconText(
                        text = "2 days ago",
                        icon = Icons.Filled.AccessTime,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    IconText(
                        text = "Full time",
                        icon = Icons.Filled.HourglassFull,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.size(144.dp, 34.dp)
                ) {
                    Text(text = "Apply now")
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        ImageVector.vectorResource(id = R.drawable.icon_bookmark),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Composable
fun IconText(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    iconSize: Dp = 10.dp,
    textStyle: TextStyle? = null,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(iconSize)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text,
            style = textStyle ?: TextStyle(
                fontSize = 12.sp,
//                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(400),
                color = Color(0x661A1A1A),
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp.ui.screens.home

import android.content.res.Configuration
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobfindingapp.JobFindingAppBar
import com.example.jobfindingapp.JobFindingBottomBar
import com.example.jobfindingapp.R
import com.example.jobfindingapp.ui.theme.JobFindingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            JobFindingAppBar(
                title = {
                    Text(
                        text = "hii, Jay",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = ImageVector.vectorResource(R.drawable.icon_menu), null)
                    }
                },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.image_profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(CircleShape)
                    )
                },
            )
        },
        bottomBar = { JobFindingBottomBar() },
    ) { innerPadding ->
        HomeScreenContent(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        )
    }
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    var searchValue by remember {
        mutableStateOf("")
    }

    val horizontalPadding = 35.dp

    Column(
        modifier = modifier
    ) {
        Text(
            "Your skill is required for many jobs",
            style = MaterialTheme.typography.displayLarge,
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
                value = searchValue,
                onValueChange = { searchValue = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        null,
                        tint = Color.White,
                        modifier = Modifier.offset(y = -3.dp)
                    )
                },
                placeholder = {
                    Text(
                        "Search any job...",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W600,
                            color = Color.White,
                        ),
                    )
                },
                modifier = Modifier
                    .size(247.dp, 65.dp)
                    .align(Alignment.BottomCenter),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    textColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = CircleShape,
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
                style = MaterialTheme.typography.displayMedium,
            )
            Text(
                "view all",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.clickable { },
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                JobCard(R.drawable.icon_swift)
            }
            for (i in 1..5) {
                item {
                    JobCard(R.drawable.icon_c_sharp)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun JobCard(@DrawableRes imageDrawable: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.size(227.dp, 234.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x26CCAFFF)
        ),
        shape = RoundedCornerShape(32.dp)
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
                    painter = painterResource(imageDrawable),
                    contentDescription = null,
                    modifier = Modifier.size(56.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
                IconText(
                    text = "4.5",
                    icon = Icons.Filled.Star,
                    textStyle = MaterialTheme.typography.titleMedium,
                    iconSize = 16.dp,
                    tint = Color(0xFFF8D048),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    "Swift Developer",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    "Delhi, New Delhi",
                    style = MaterialTheme.typography.titleSmall,
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
                    Text(
                        text = "Apply now",
                        style = MaterialTheme.typography.labelMedium,
                    )
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
    tint: Color = Color.Unspecified,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = tint,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text,
            style = textStyle ?: MaterialTheme.typography.bodySmall,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JobFindingAppTheme {
        HomeScreen()
    }
}

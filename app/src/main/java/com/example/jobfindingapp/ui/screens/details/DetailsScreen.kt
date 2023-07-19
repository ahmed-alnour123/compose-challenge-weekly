@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobfindingapp.JobFindingAppBar
import com.example.jobfindingapp.R
import com.example.jobfindingapp.ui.screens.home.IconText
import com.example.jobfindingapp.ui.theme.DarkGray
import com.example.jobfindingapp.ui.theme.JobFindingAppTheme
import com.example.jobfindingapp.ui.theme.LightGray
import com.example.jobfindingapp.ui.theme.LightPink
import com.example.jobfindingapp.ui.theme.TransparentLightPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            JobFindingAppBar(
                title = {
                    Text(
                        text = "Infosys",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_bookmark_icon),
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier
                            .size(25.dp)
                            .clip(CircleShape)
                    )
                },
            )
        },
        bottomBar = {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(start = 35.dp, end = 35.dp, bottom = 22.dp)
                    .height(53.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Apply now",
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    ) { innerPadding ->
        DetailsScreenContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun DetailsScreenContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 35.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(7.dp),
        ) {
            Image(
                painterResource(id = R.drawable.ic_c_sharp_icon),
                null,
                modifier = Modifier
                    .size(80.dp),
            )
            Text(
                "C Sharp Developer",
                style = MaterialTheme.typography.displayMedium
            )
            Row {
                Text(
                    "Infosys",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = DarkGray,
                    ),
                )
                Text(
                    "\u2022",
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    modifier = Modifier.weight(1f),
                    color = DarkGray,
                )
                Text(
                    "Gurugram",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = DarkGray,
                    ),
                )
                Text(
                    "\u2022",
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    modifier = Modifier.weight(1f),
                    color = DarkGray,
                )
                Text(
                    "1 Day ago",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = DarkGray,
                    ),
                )
            }
        }
        Column {
            DetailsLine()
            Row {
                Spacer(modifier = Modifier.weight(0.25f))
                Text(
                    "Salary",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "Type",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "Ratings",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.weight(0.25f))
            }
            Row {
                Spacer(modifier = Modifier.weight(0.25f))
                Text(
                    "$10 k",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = LightPink,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "Full time",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = LightPink,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                IconText(
                    text = "4.5",
                    textStyle = MaterialTheme.typography.titleLarge.copy(
                        color = LightPink,
                    ),
                    icon = Icons.Filled.Star,
                    iconSize = 18.dp,
                    tint = Color(0xFFF8D048),
                )
                Spacer(modifier = Modifier.weight(0.25f))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(color = Color(0x1ACCAFFF), shape = RoundedCornerShape(size = 16.dp))
                .padding(horizontal = 4.dp, vertical = 7.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextButton(
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "About Company",
                    style = MaterialTheme.typography.bodySmall,
                )
            }
            TextButton(modifier = Modifier
                .weight(1f)
                .background(
                    color = Color(0xFFCCAFFF),
                    shape = RoundedCornerShape(size = 12.dp)
                ),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Job Description",
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                "About Job",
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                """
               Infosys Limited is an Indian multinational information
               technology company that provides business consulting,
               information technology and outsource services. 
            """.trimIndent().replace("\n", " "),
                style = MaterialTheme.typography.titleSmall,
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                "Job description",
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                """
                We are looking for a C# developer to build
                software using languages, technologies of the
                .NET framework. 
                You will create applications from scratch, configure
                existing systems and provide user support.Must have
                Potential to design, develop program independently.
            """.trimIndent().replace("\n", " "),
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}

@Composable
fun DetailsLine() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val Point = @Composable {
                Box(
                    modifier = Modifier
                        .size(17.dp)
                        .clip(CircleShape)
                        .background(LightPink)
                )
            }
            val Line = @Composable { color: Color? ->
                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .weight(1f)
                        .background(color ?: MaterialTheme.colorScheme.primary)
                )
            }
            Line(TransparentLightPink)
            Point()
            Line(null)

            Line(null)
            Point()
            Line(null)

            Line(null)
            Point()
            Line(TransparentLightPink)
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    JobFindingAppTheme {
        DetailsScreen()
    }
}
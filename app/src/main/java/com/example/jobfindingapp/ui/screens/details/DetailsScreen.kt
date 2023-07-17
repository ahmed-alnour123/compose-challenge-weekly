@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp.ui.screens.details

import android.telecom.Call.Details
import android.widget.ProgressBar
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfindingapp.JobFindingAppBar
import com.example.jobfindingapp.JobFindingBottomBar
import com.example.jobfindingapp.R
import com.example.jobfindingapp.ui.screens.home.IconText
import com.example.jobfindingapp.ui.theme.JobFindingAppTheme

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
                        imageVector = ImageVector.vectorResource(R.drawable.icon_bookmark),
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
                    .height(53.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp)
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
        modifier = modifier,
    ) {
        Column {
            Image(painterResource(id = R.drawable.icon_c_sharp), null)
            Text("C Sharp Developer")
            Row {
                Text("Infosys")
                Text(".", modifier = Modifier.weight(1f))
                Text("Gurugram")
                Text(".", modifier = Modifier.weight(1f))
                Text("1 Day ago")
            }
        }
        Column {
            LinearProgressIndicator()
            Row {
                Text("Salary")
                Text("Type")
                Text("Ratings")
            }
            Row {
                Text("$10 k")
                Text("Full time")
                IconText(text = "4.5", icon = Icons.Filled.Star)
            }
        }
        Row {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "About Company")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Job Description")
            }
        }
        Column {
            Text("About Job")
            Text(
                """
               Infosys Limited is an Indian multinational information
               technology company that provides business consulting,
               information technology and outsource services. 
            """.trimIndent().replace("\n", " ")
            )
        }
        Column {
            Text("Job description")
            Text(
                """
                We are looking for a C# developer to build
                software using languages, technologies of the
                .NET framework. 
                You will create applications from scratch, configure
                existing systems and provide user support.Must have
                Potential to design, develop program independently.
            """.trimIndent().replace("\n", " ")
            )
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    JobFindingAppTheme{
        DetailsScreen()
    }
}
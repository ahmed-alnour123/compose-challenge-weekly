@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp.ui.screens.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobfindingapp.JobFindingAppBar
import com.example.jobfindingapp.R
import com.example.jobfindingapp.data.DataSource
import com.example.jobfindingapp.models.Job
import com.example.jobfindingapp.ui.theme.DarkGray
import com.example.jobfindingapp.ui.theme.JobFindingAppTheme
import com.example.jobfindingapp.ui.theme.LightPink
import com.example.jobfindingapp.utils.AppBarAction
import com.example.jobfindingapp.utils.widgets.IconText

@Composable
fun DetailsScreen(
    job: Job,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState = DetailsScreenUiState(job)

    BackHandler {
        onBackButtonClicked()
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            JobFindingAppBar(
                title = job.companyName,
                isHomeScreen = false,
                appBarAction = AppBarAction.Bookmark,
                onBackButtonClicked = onBackButtonClicked,
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
                    text = stringResource(id = R.string.apply_now),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    ) { innerPadding ->
        DetailsScreenContent(
            uiState,
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )
    }
}

@Composable
fun DetailsScreenContent(uiState: DetailsScreenUiState, modifier: Modifier = Modifier) {
    val job = uiState.job
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
                painterResource(job.icon),
                null,
                modifier = Modifier
                    .size(80.dp),
            )
            Text(
                job.title,
                style = MaterialTheme.typography.displayMedium
            )
            Row {
                Text(
                    job.companyName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = DarkGray,
                    ),
                )
                Text(
                    "\u2022",
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    modifier = Modifier
                        .weight(1f)
                        .offset(y = -4.dp),
                    color = DarkGray,
                )
                Text(
                    job.city,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = DarkGray,
                    ),
                )
                Text(
                    "\u2022",
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    modifier = Modifier
                        .weight(1f)
                        .offset(y = -4.dp),
                    color = DarkGray,
                )
                Text(
                    job.postedDate,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = DarkGray,
                    ),
                )
            }
        }
        Column {
            SalaryRangeBar()
            Row {
                Spacer(modifier = Modifier.weight(0.25f))
                Text(
                    stringResource(id = R.string.salary),
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    stringResource(id = R.string.type),
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    stringResource(id = R.string.ratings),
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.weight(0.25f))
            }
            Row {
                Spacer(modifier = Modifier.weight(0.25f))
                Text(
                    job.salary,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = LightPink,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    job.jobTime,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = LightPink,
                    ),
                )
                Spacer(modifier = Modifier.weight(1f))
                IconText(
                    text = job.rating,
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
        AboutSections(job)
    }
}


@Composable
fun AboutSections(job: Job) {
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
                text = stringResource(id = R.string.about_company),
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
                text = stringResource(id = R.string.job_description),
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }

    TextSection(
        title = stringResource(id = R.string.about_job),
        body = job.aboutJob,
    )
    TextSection(
        title = stringResource(id = R.string.job_description),
        body = job.description,
    )
}

data class DetailsScreenUiState(
    val job: Job,
)

@Preview
@Composable
fun DetailsScreenPreview() {
    JobFindingAppTheme {
        DetailsScreen(
            job = DataSource.jobsList.first(),
            onBackButtonClicked = {}
        )
    }
}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jobfindingapp.JobFindingAppBar
import com.example.jobfindingapp.JobFindingBottomBar
import com.example.jobfindingapp.R
import com.example.jobfindingapp.data.DataSource
import com.example.jobfindingapp.models.Job
import com.example.jobfindingapp.ui.theme.JobFindingAppTheme
import com.example.jobfindingapp.utils.AppBarAction

@Composable
fun HomeScreen(
    onApplyButtonClicked: (job: Job) -> Unit,
    modifier: Modifier = Modifier,
) {
    val uiState = HomeScreenUiState(
        username = "Jay",
        userImage = R.drawable.img_profile,
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            JobFindingAppBar(
                title = stringResource(id = R.string.hi_user, uiState.username),
                isHomeScreen = true,
                profileImage = uiState.userImage,
                appBarAction = AppBarAction.Profile,
            )
        },
        bottomBar = { JobFindingBottomBar() },
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            HomeScreenContent()
            JobList(
                DataSource.jobsList,
                onApplyButtonClicked = onApplyButtonClicked,
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 35.dp)
    ) {
        Text(
            stringResource(id = R.string.your_skill_is_required),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(27.dp))
        SearchBox()
        Spacer(modifier = Modifier.height(27.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                stringResource(id = R.string.based_on_your_skills),
                style = MaterialTheme.typography.displayMedium,
            )
            Text(
                stringResource(id = R.string.view_all),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.clickable { },
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun JobList(
    jobs: List<Job>,
    onApplyButtonClicked: (job: Job) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        item { Spacer(modifier = Modifier.width(15.dp)) }
        items(jobs) { job ->
            JobCard(
                job = job,
                onApplyButtonClicked = { onApplyButtonClicked(job) }
            )
        }
        item { Spacer(modifier = Modifier.width(20.dp)) }
    }
}

data class HomeScreenUiState(
    val username: String,
    @DrawableRes val userImage: Int,
)

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JobFindingAppTheme {
        HomeScreen(onApplyButtonClicked = {})
    }
}

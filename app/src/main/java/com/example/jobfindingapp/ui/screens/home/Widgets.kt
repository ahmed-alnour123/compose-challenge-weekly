@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.HourglassFull
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jobfindingapp.R
import com.example.jobfindingapp.models.Job
import com.example.jobfindingapp.utils.widgets.IconText

@Composable
fun SearchBox(modifier: Modifier = Modifier) {
    var searchValue by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.img_home_screen),
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
                    modifier = Modifier.offset(x = 12.dp, y = -3.dp)
                )
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.search_any_job),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        color = Color.White,
                    ),
                )
            },
            modifier = Modifier
                .padding(horizontal = 49.dp)
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
}

@Composable
fun JobCard(
    job: Job,
    onApplyButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
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
                    painter = painterResource(job.icon),
                    contentDescription = null,
                    modifier = Modifier.size(56.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
                IconText(
                    text = job.rating,
                    icon = Icons.Filled.Star,
                    textStyle = MaterialTheme.typography.titleMedium,
                    iconSize = 16.dp,
                    tint = Color(0xFFF8D048),
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(
                    job.title,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    "${job.city}, ${job.town}",
                    style = MaterialTheme.typography.titleSmall,
                )
                Row {
                    IconText(
                        text = job.postedDate,
                        icon = Icons.Filled.AccessTime,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    IconText(
                        text = job.jobTime,
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
                    onClick = onApplyButtonClicked,
                    modifier = Modifier.size(144.dp, 34.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.apply_now),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        ImageVector.vectorResource(id = R.drawable.ic_bookmark_icon),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jobfindingapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jobfindingapp.R

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

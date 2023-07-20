package com.example.jobfindingapp.ui.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextSection(
    title: String,
    body: String,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            body,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}

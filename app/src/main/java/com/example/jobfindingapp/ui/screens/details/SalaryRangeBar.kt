package com.example.jobfindingapp.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jobfindingapp.ui.theme.LightPink
import com.example.jobfindingapp.ui.theme.TransparentLightPink

@Composable
fun SalaryRangeBar() {
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

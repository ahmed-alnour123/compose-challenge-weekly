package com.example.jobfindingapp.utils.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
            modifier = Modifier
                .size(iconSize)
                .offset(y = -2.dp),
            tint = tint,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text,
            style = textStyle ?: MaterialTheme.typography.bodySmall,
        )
    }
}

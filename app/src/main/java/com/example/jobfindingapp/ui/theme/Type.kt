package com.example.jobfindingapp.ui.theme

import android.provider.CalendarContract
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jobfindingapp.R

val poppins = FontFamily(
    Font(R.font.f_100_poppins_thin, FontWeight.Thin),
    Font(R.font.f_200_poppins_extralight, FontWeight.ExtraLight),
    Font(R.font.f_300_poppins_light, FontWeight.Light),
    Font(R.font.f_400_poppins_regular),
    Font(R.font.f_500_poppins_medium, FontWeight.Medium),
    Font(R.font.f_600_poppins_semibold, FontWeight.SemiBold),
    Font(R.font.f_700_poppins_bold, FontWeight.Bold),
    Font(R.font.f_800_poppins_extrabold, FontWeight.ExtraBold),
    Font(R.font.f_900_poppins_black, FontWeight.Black),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = poppins,
        fontWeight = FontWeight(400),
        color = DarkGray,
    ),

    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = poppins,
        fontWeight = FontWeight(700),
        color = Color.White,
    ),

    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = poppins,
        fontWeight = FontWeight(500),
        color = DarkGray,
    ),

    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = poppins,
        fontWeight = FontWeight(500),
        color = LightGray,
    ),

    titleLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = poppins,
        fontWeight = FontWeight(500),
        color = LightGray,
    ),

    displayMedium = TextStyle(
        fontSize = 20.sp,
        fontFamily = poppins,
        fontWeight = FontWeight(500),
        color = LightGray,
    ),

    displayLarge = TextStyle(
        fontSize = 28.sp,
        lineHeight = 38.sp,
        fontFamily = poppins,
        fontWeight = FontWeight(600),
        color = LightGray,
    )
)
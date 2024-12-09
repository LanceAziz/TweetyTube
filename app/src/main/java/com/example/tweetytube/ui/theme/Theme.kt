package com.example.tweetytube.ui.theme

import MyTypography
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    secondary = secondaryLight,
    tertiary = warningLight,
    surface = successLight,
    error = errorLight,
    outline = outlineLight,
    background = bgLight,
)
private val darkScheme = darkColorScheme(
    primary = primaryDark,
    secondary = secondaryDark,
    tertiary = warningDark,
    surface = successDark,
    error = errorDark,
    outline = outlineDark,
    background = bgDark,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Automatically detect system theme
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkScheme
    } else {
        lightScheme
    }
    MaterialTheme(
        colorScheme = colors,
        typography = MyTypography,
        content = content
    )
}
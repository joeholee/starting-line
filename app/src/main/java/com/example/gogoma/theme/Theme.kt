package com.example.gogoma.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BrandColor1,
    secondary = BrandColor2,
    tertiary = BrandColor3
)

private val LightColorScheme = lightColorScheme(
    primary = BrandColor1,
    primaryContainer = BrandColor1_30pct,
    secondary = BrandColor2,
    tertiary = BrandColor3,
    onPrimary = NeutralWhite,
    onSecondary = NeutralDark,
    onTertiary = NeutralDark,
    background = NeutralWhite,
    onBackground = NeutralBlack,
    surface = NeutralWhite,
    error = CustomRed

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun GogomaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicLightColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> LightColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

private val SplashColorScheme = lightColorScheme(
    surface = BrandColor1,
    onBackground = NeutralWhite,
)

@Composable
fun SplashTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = SplashColorScheme,
        typography = Typography,
        content = content
    )
}
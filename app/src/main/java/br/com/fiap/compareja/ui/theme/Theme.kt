package br.com.fiap.compareja.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Laranja,
    primaryContainer = LaranjaClaro,
    onPrimary = BrancoPuro,
    secondary = BrancoCreme,
    onSecondary = Preto,
    background = LaranjaClaro,
    onBackground = BrancoPuro,
    surface = BrancoCreme,
    onSurface = Preto,
    tertiary = CinzaClaro
)

private val DarkColorScheme = darkColorScheme(
    primary = Laranja,
    primaryContainer = LaranjaClaro,
    onPrimary = BrancoPuro,
    secondary = BrancoCreme,
    onSecondary = BrancoPuro,
    background = Color(0xFF121212),
    onBackground = BrancoPuro,
    surface = Color(0xFF1F1F1F),
    onSurface = BrancoPuro,
    tertiary = CinzaClaro
)

@Composable
fun CompareJaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

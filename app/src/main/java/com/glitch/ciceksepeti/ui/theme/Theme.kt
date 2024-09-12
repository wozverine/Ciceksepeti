package com.glitch.ciceksepeti.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

private val DarkColorScheme = darkColorScheme(
	primary = Purple80,
	secondary = PurpleGrey80,
	tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
	primary = Black40,
	secondary = White40,
	tertiary = Blue40,
	/*background = Color(0xFFFFFFFF),
	onBackground = Color(0xFFFFFFFF),*/
	//Other default colors to override

	background = Color.White,   // Ensure background is white
	onBackground = Color.Black, // Text on background will be black
	surface = Color.White,      // Surface color can also influence backgrounds
	onSurface = Color.Black     // Text on surface will be black

	/*surface = Color(0xFFFFFBFE),
	onPrimary = Color.White,
	onSecondary = Color.White,
	onTertiary = Color.White,
	onBackground = Color(0xFF1C1B1F),
	onSurface = Color(0xFF1C1B1F),
	*/
)

@Composable
fun CiceksepetiTheme(
	//darkTheme: Boolean = isSystemInDarkTheme(),
	darkTheme: Boolean = false,
	// Dynamic color is available on Android 12+
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

	val view = LocalView.current
	if (!view.isInEditMode) {
		SideEffect {
			val window = (view.context as Activity).window
			window.statusBarColor = LightColorScheme.secondary.toArgb()
			WindowCompat.setDecorFitsSystemWindows(window, false)
			val insetsController = WindowInsetsControllerCompat(window, window.decorView)
			insetsController.isAppearanceLightStatusBars = !darkTheme
		}
	}

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}
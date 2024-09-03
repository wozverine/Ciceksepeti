package com.glitch.ciceksepeti.uix.views

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalConfiguration

@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun PresentScreen() {

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	Scaffold(
		topBar = {
			TopAppBar(title = { Text(text = "Movies") })
		}
	) { paddingValues ->

	}

}

/*
@Preview(
	showBackground = true
)
@Composable
fun PresentPreview() {
	AppTheme {
		PresentScreen()
	}
}*/
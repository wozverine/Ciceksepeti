package com.glitch.ciceksepeti.uix.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme
import com.glitch.ciceksepeti.ui.theme.Green167

@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun FavoritesScreen(navigateBack: () -> Unit) {

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	@Composable
	fun CustomTopAppBarNoPadding(title: String) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.White)
				.height(56.dp)
				.padding(0.dp)
		) {
			Text(
				text = title,
				fontSize = 14.sp,
				color = Color.Black,
				textAlign = TextAlign.Center,
				modifier = Modifier
					.align(Alignment.Center)
					.padding(0.dp)
					.fillMaxWidth()
			)
		}
	}

	Scaffold(
		topBar = {
			CustomTopAppBarNoPadding(title = stringResource(id = R.string.favorites))
		}
	) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center

		) {
			Image(
				painter = painterResource(
					id = R.drawable.benim,
				),
				modifier = Modifier
					.padding(vertical = 10.dp)
				//.height((screenHeight / 6).dp)
				//.fillMaxWidth(),
				,
				contentScale = ContentScale.Fit,
				contentDescription = ""
			)
			Text(text = stringResource(id = R.string.fav_empty))
			Button(
				onClick = {
					navigateBack()
				},
				colors = ButtonDefaults.buttonColors(
					containerColor = Green167,
				),
				shape = RoundedCornerShape(10.dp)
			) {
				Text(text = stringResource(id = R.string.list))
			}
		}
	}

}

@Preview(
	showBackground = true,
	//uiMode = UI_MODE_NIGHT_YES
	locale = "tr"
)
@Composable
fun FavoritesPreview() {
	CiceksepetiTheme {
		val navController = rememberNavController()

		FavoritesScreen(navigateBack = { navController.popBackStack() })
	}
}
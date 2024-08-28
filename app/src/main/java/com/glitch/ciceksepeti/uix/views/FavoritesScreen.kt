package com.glitch.ciceksepeti.uix.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme
import com.glitch.ciceksepeti.ui.theme.Green167

@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun FavoritesScreen() {

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	Scaffold(
		topBar = {
			TopAppBar(title = { Text(text = stringResource(id = R.string.favorites)) })
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
					id = R.drawable.cart,
				),
				modifier = Modifier
					.padding(vertical = 10.dp)
				//.height((screenHeight / 6).dp)
				//.fillMaxWidth(),
				,
				contentScale = ContentScale.Fit,
				contentDescription = ""
			)
			Text(text = "Sepetinizde ürün bulunmamaktadır.")
			Button(
				onClick = {
					/*TODO*/
				},
				colors = ButtonDefaults.buttonColors(
					containerColor = Green167,
				),
				shape = RoundedCornerShape(10.dp)
			) {
				Text(
					text = "Alışverişe başla"
				)
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

		FavoritesScreen()
	}
}
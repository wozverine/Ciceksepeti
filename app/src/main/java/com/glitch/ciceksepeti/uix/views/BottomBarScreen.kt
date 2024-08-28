package com.glitch.ciceksepeti.uix.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme

@Composable


fun BottomBarScreen() {
	val selectedItem = remember { mutableStateOf(0) }
	val showBottomBar = remember { mutableStateOf(true) }

	Scaffold(
		bottomBar = {
			if (showBottomBar.value) {
				BottomAppBar(
					containerColor = Color.White,
					content = {
						NavigationBarItem(
							selected = selectedItem.value == 0,
							onClick = {
								selectedItem.value = 0
							},
							icon = {
								Icon(
									painter = painterResource(id = R.drawable.ic_home),
									contentDescription = ""
								)
							},
							label = { Text(text = "Mainpage") }
						)

						NavigationBarItem(
							selected = selectedItem.value == 1,
							onClick = {
								selectedItem.value = 1
							},
							icon = {
								Icon(
									painter = painterResource(id = R.drawable.ic_category),
									contentDescription = ""
								)
							},
							label = { Text(text = "Category") }
						)

						NavigationBarItem(
							selected = selectedItem.value == 2,
							onClick = {
								selectedItem.value = 2
							},
							icon = {
								Icon(
									painter = painterResource(id = R.drawable.ic_favorites),
									contentDescription = ""
								)
							},
							label = { Text(text = "Favorites") }
						)

						NavigationBarItem(
							selected = selectedItem.value == 3,
							onClick = {
								selectedItem.value = 3
							},
							icon = {
								Icon(
									painter = painterResource(id = R.drawable.ic_cart),
									contentDescription = ""
								)
							},
							label = { Text(text = "Cart") }
						)

						NavigationBarItem(
							selected = selectedItem.value == 4,
							onClick = {
								selectedItem.value = 4
							},
							icon = {
								Icon(
									painter = painterResource(id = R.drawable.ic_person),
									contentDescription = ""
								)
							},
							label = { Text(text = "Account") }
						)
					}
				)
			}
		}
	) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues),
			verticalArrangement = Arrangement.SpaceEvenly,
			horizontalAlignment = Alignment.CenterHorizontally
		) {

			when (selectedItem.value) {
				0 -> PageSwitch(chosenPage = "mainpage")
				1 -> PageSwitch(chosenPage = "categorypage")
				2 -> PageSwitch(chosenPage = "favoritespage")
				3 -> {
					showBottomBar.value = false
					CartScreen {
						showBottomBar.value = true
						selectedItem.value = 0
					}
				}
				4 -> PageSwitch(chosenPage = "accountpage")
			}
			/*if (selectedItem.value == 0) PageSwitch(chosenPage = "mainpage")
			if (selectedItem.value == 1) PageSwitch(chosenPage = "categorypage")
			if (selectedItem.value == 2) PageSwitch(chosenPage = "favoritespage")
			if (selectedItem.value == 3) PageSwitch(chosenPage = "cartscreen")
			if (selectedItem.value == 4) PageSwitch(chosenPage = "accountpage")*/
		}
	}

}

@Preview(
	showBackground = true
)
@Composable
fun BottomBarPreview() {
	CiceksepetiTheme {
		BottomBarScreen()
	}
}
package com.glitch.ciceksepeti.uix.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme
import kotlinx.coroutines.launch

@Composable


fun BottomBarScreen() {
	val selectedItem = remember { mutableStateOf(0) }
	val showBottomBar = remember { mutableStateOf(true) }
	val showTopBar = remember { mutableStateOf(true) }
	val tabIndex = remember { mutableStateOf(0) }
	val scope = rememberCoroutineScope()

	Scaffold(bottomBar = {
		if (showBottomBar.value) {
			BottomAppBar(containerColor = Color.White, content = {
				NavigationBarItem(selected = selectedItem.value == 0, onClick = {
					selectedItem.value = 0
				}, icon = {
					Icon(
						painter = painterResource(id = R.drawable.cicekicon3),
						contentDescription = ""
					)
				}, label = { Text(text = "Mainpage") })

				NavigationBarItem(selected = selectedItem.value == 1, onClick = {
					selectedItem.value = 1
				}, icon = {
					Icon(
						painter = painterResource(id = R.drawable.ic_category),
						contentDescription = ""
					)
				}, label = { Text(text = "Category") })

				NavigationBarItem(selected = selectedItem.value == 2, onClick = {
					selectedItem.value = 2
				}, icon = {
					Icon(
						painter = painterResource(id = R.drawable.ic_favorites),
						contentDescription = ""
					)
				}, label = { Text(text = "Favorites") })

				NavigationBarItem(selected = selectedItem.value == 3, onClick = {
					selectedItem.value = 3
				}, icon = {
					Icon(
						painter = painterResource(id = R.drawable.ic_cart),
						contentDescription = ""
					)
				}, label = { Text(text = "Cart") })

				NavigationBarItem(selected = selectedItem.value == 4, onClick = {
					selectedItem.value = 4
				}, icon = {
					Icon(
						painter = painterResource(id = R.drawable.ic_person),
						contentDescription = ""
					)
				}, label = { Text(text = "Account") })
			})
		}
	}) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues),
			verticalArrangement = Arrangement.SpaceEvenly,
			horizontalAlignment = Alignment.CenterHorizontally
		) {

			when (selectedItem.value) {
				0 -> {
					Column {
						TabRow(
							selectedTabIndex = tabIndex.value, Modifier.background(Color.White)
						) {
							Tab(text = { Text("Çiçek ve Çikolata") }, icon = {
								Image(
									painter = painterResource(id = R.drawable.ic_cicektext),
									contentDescription = "Search"
								)
							}, selected = tabIndex.value == 0, onClick = {
								scope.launch { tabIndex.value = 0 }
							})
							Tab(text = { Text("Presents") }, icon = {
								Image(
									painter = painterResource(id = R.drawable.ic_presenttext),
									contentDescription = "Search"
								)
							}, selected = tabIndex.value == 1, onClick = {
								scope.launch { tabIndex.value = 1 }
							})
						}
						when (tabIndex.value) {
							0 -> PageSwitch(chosenPage = "flowerscreen")
							1 -> Text("Presents content")
						}
					}
				}

				1 -> PageSwitch(chosenPage = "categorypage")
				2 -> PageSwitch(chosenPage = "favoritespage")
				3 -> {
					showBottomBar.value = false
					CartScreen {
						showBottomBar.value = true
						selectedItem.value = 0
					}
				}

				4 -> {
					PageSwitch(chosenPage = "accountpage")
				}
			}
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
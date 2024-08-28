package com.glitch.ciceksepeti.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PageSwitch(chosenPage: String) {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = chosenPage) {
		composable("mainpage") {
			//MainPage(navController = navController)
		}
		composable("categorypage") {
			//MainPage(navController = navController)
		}
		composable("favoritespage") {
			//MainPage(navController = navController)
		}
		composable("cartscreen") {
			CartScreen(
				navigateBack = { navController.popBackStack() }
			)
		}
		composable("accountpage") {
			//MainPage(navController = navController)
		}
	}

}

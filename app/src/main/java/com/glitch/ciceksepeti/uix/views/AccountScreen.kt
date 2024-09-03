package com.glitch.ciceksepeti.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.data.entity.Accountmenu
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun AccountScreen(navController: NavController) {

	val configuration = LocalConfiguration.current
	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	val menuList = remember { mutableStateListOf<Accountmenu>() }
	val scope = rememberCoroutineScope()

	LaunchedEffect(key1 = true) {
		val m1 = Accountmenu(1, "Siparişlerim", "siparis")
		val m2 = Accountmenu(2, "Kuponlarım", "coupon")
		val m3 = Accountmenu(3, "Değerlendirmelerim", "review")
		val m4 = Accountmenu(4, "Üyelik Bilgilerim", "myaccount")
		val m5 = Accountmenu(5, "Mesajlarım", "message")
		val m6 = Accountmenu(6, "Adreslerim", "addresses")
		val m7 = Accountmenu(7, "Hatırlatmalarım", "reminders")
		val m8 = Accountmenu(8, "Cüzdanım", "reminders")
		val m9 = Accountmenu(9, "Kayıtlı Kartlarım", "reminders")
		menuList.add(m1)
		menuList.add(m2)
		menuList.add(m3)
		menuList.add(m4)
		menuList.add(m5)
		menuList.add(m6)
		menuList.add(m7)
		menuList.add(m8)
		menuList.add(m9)
	}

	Scaffold(topBar = {
		TopAppBar(title = { Text(text = stringResource(id = R.string.account)) })
	}) { paddingValues ->
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues)
		) {
			items(count = menuList.count(), itemContent = {
				val menu = menuList[it]
				Card(
					modifier = Modifier.padding(all = 5.dp),
					colors = CardDefaults.cardColors(
						containerColor = Color.White
					)
				) {
					Row(
						modifier = Modifier
							.fillMaxWidth(),
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.SpaceBetween
					) {
						val activity = LocalContext.current as Activity
						Image(
							bitmap = ImageBitmap.imageResource(
								id = activity.resources.getIdentifier(
									menu.image, "drawable", activity.packageName
								)
							), contentDescription = ""
						)
						Text(text = menu.name)
						Image(
							painter = painterResource(id = R.drawable.backicon),
							contentDescription = null,
						)
					}
				}
			})
		}
	}
}

@Preview(
	showBackground = true,
	locale = "tr"
)
@Composable
fun AccountPreview() {
	CiceksepetiTheme {
		val navController = rememberNavController()
		AccountScreen(navController)
	}
}
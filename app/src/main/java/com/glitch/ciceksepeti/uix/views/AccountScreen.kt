package com.glitch.ciceksepeti.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
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
		val m8 = Accountmenu(8, "Cüzdanım", "wallet")
		val m9 = Accountmenu(9, "Kayıtlı Kartlarım", "savedcards")
		val m10 = Accountmenu(10, "Favori Ürünlerim", "favori")
		val m11 = Accountmenu(11, "Koleksiyonlarım", "collections")
		val m12 = Accountmenu(12, "Bildirimler", "notification")
		val m13 = Accountmenu(13, "Canlı Destek", "live")
		val m14 = Accountmenu(14, "Yardım", "help")
		val m15 = Accountmenu(15, "VideoCard", "videocard")
		val m16 = Accountmenu(16, "Kampanyalar", "offers")
		val m17 = Accountmenu(17, "Uygulamayı Oyla", "rateapp")
		menuList.add(m1)
		menuList.add(m2)
		menuList.add(m3)
		menuList.add(m4)
		menuList.add(m5)
		menuList.add(m6)
		menuList.add(m7)
		menuList.add(m8)
		menuList.add(m9)
		menuList.add(m10)
		menuList.add(m11)
		menuList.add(m12)
		menuList.add(m13)
		menuList.add(m14)
		menuList.add(m15)
		menuList.add(m16)
		menuList.add(m17)
	}

	@Composable
	fun CustomTopAppBar(title: String) {
		CenterAlignedTopAppBar(
			windowInsets = WindowInsets(
				top = 0.dp,
				bottom = 0.dp
			),
			title = {
				Box(
					modifier = Modifier
						.padding(vertical = 0.dp)
						.fillMaxWidth(),
				) {
					Text(
						modifier = Modifier
							.padding(0.dp)
							.fillMaxWidth(),
						text = title,
						fontSize = 14.sp,
						textAlign = TextAlign.Center
					)
				}
			},
			modifier = Modifier
				.padding(0.dp)
				.fillMaxWidth(),
			colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White),
		)
	}

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


	Scaffold(topBar = {
		CustomTopAppBarNoPadding(title = stringResource(id = R.string.account))
	}) { paddingValues ->
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(
					top = paddingValues.calculateTopPadding(), bottom = 0.dp
				),
		) {

			items(count = menuList.count()) { index ->
				val menu = menuList[index]
				HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
				Card(
					colors = CardDefaults.cardColors(
						containerColor = Color.White
					)
				) {
					ConstraintLayout(
						modifier = Modifier
							.fillMaxWidth()
							.padding(horizontal = 5.dp)
					) {
						val (firstImage, text, lastImage) = createRefs()
						val activity = LocalContext.current as Activity

						Image(
							modifier = Modifier
								.padding(vertical = 5.dp)
								.constrainAs(firstImage) {
									start.linkTo(parent.start)
									top.linkTo(parent.top)
									bottom.linkTo(parent.bottom)
								}, bitmap = ImageBitmap.imageResource(
								id = activity.resources.getIdentifier(
									menu.image, "drawable", activity.packageName
								)
							), contentDescription = ""
						)

						Text(
							modifier = Modifier
								.padding(vertical = 5.dp)
								.constrainAs(text) {
									start.linkTo(firstImage.end)
									top.linkTo(parent.top)
									bottom.linkTo(parent.bottom)
									end.linkTo(lastImage.start)
								}, text = menu.name
						)

						Image(
							modifier = Modifier
								.padding(vertical = 5.dp)
								.constrainAs(lastImage) {
									end.linkTo(parent.end)
									top.linkTo(parent.top)
									bottom.linkTo(parent.bottom)
								},
							painter = painterResource(id = R.drawable.backicon),
							contentDescription = null
						)
					}
				}
			}

			item {
				Text(
					modifier = Modifier
						.padding(vertical = 12.dp)
						.fillMaxWidth(),
					text = "Mevcut Sürüm 6.5.6 (97597)",
					textAlign = TextAlign.Center,
					color = Color.LightGray,
					fontSize = 10.sp
				)
			}
		}
	}
}

@Preview(
	showBackground = true, locale = "tr"
)
@Composable
fun AccountPreview() {
	CiceksepetiTheme {
		val navController = rememberNavController()
		AccountScreen(navController)
	}
}
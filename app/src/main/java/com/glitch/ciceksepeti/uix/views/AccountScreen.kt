package com.glitch.ciceksepeti.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.data.entity.Accountmenu
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme

@Composable
fun AccountScreen() {

	val menuList = remember { mutableStateListOf<Accountmenu>() }

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
		topBar = { CustomTopAppBarNoPadding(title = stringResource(id = R.string.account)) }
	) { paddingValues ->
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(
					top = paddingValues.calculateTopPadding(), bottom = 0.dp
				)
				.background(Color.White),
		) {

			items(count = menuList.count()) { index ->
				val menu = menuList[index]
				HorizontalDivider(
					thickness = 1.dp, color = colorResource(id = R.color.lighter_grey)
				)
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
								.padding(vertical = 14.dp)
								.padding(start = 8.dp)
								.constrainAs(text) {
									start.linkTo(firstImage.end)
									top.linkTo(parent.top)
									bottom.linkTo(parent.bottom)
								},
							text = menu.name,
							fontSize = 14.sp,
							color = Color.Black
						)

						Image(
							modifier = Modifier
								.padding(vertical = 14.dp)
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
						.padding(vertical = 14.dp)
						.fillMaxWidth(),
					text = stringResource(id = R.string.surum),
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
		AccountScreen()
	}
}
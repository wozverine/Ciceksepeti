package com.glitch.ciceksepeti.uix.views

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.data.entity.Flowerstory
import com.glitch.ciceksepeti.data.entity.Offermenu
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun FlowerScreen() {
	val configuration = LocalConfiguration.current
	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	val storyList = remember { mutableStateListOf<Flowerstory>() }
	val offerList = remember { mutableStateListOf<Offermenu>() }

	LaunchedEffect(key1 = true) {
		val m1 = Flowerstory(1, "Doğum Günü Çiçeği", "row1")
		val m2 = Flowerstory(2, "Aynı Gün Hediye Seti", "row2")
		val m3 = Flowerstory(3, "Teraryum", "row3")
		val m4 = Flowerstory(4, "Yenilebilir Çiçekler", "row4")
		val m5 = Flowerstory(5, "Çiçekler", "row5")
		val m6 = Flowerstory(6, "Saksı Çiçekleri", "row6")
		val m7 = Flowerstory(7, "Yıldönümü Çiçekleri", "row7")
		val m8 = Flowerstory(8, "Sevgiliye Çiçekler", "reminders")
		val m9 = Flowerstory(9, "Çikolata", "reminders")
		storyList.add(m1)
		storyList.add(m2)
		storyList.add(m3)
		storyList.add(m4)
		storyList.add(m5)
		storyList.add(m6)
		storyList.add(m7)
		storyList.add(m8)
		storyList.add(m9)

		val o1 = Offermenu(0, "column1")
		val o2 = Offermenu(1, "column2")
		val o3 = Offermenu(2, "column3")
		val o4 = Offermenu(3, "column4")
		val o5 = Offermenu(4, "column5")
		val o6 = Offermenu(5, "column6")
		val o7 = Offermenu(6, "column7")
		offerList.add(o1)
		offerList.add(o2)
		offerList.add(o3)
		offerList.add(o4)
		offerList.add(o5)
		offerList.add(o6)
		offerList.add(o7)
	}

	Scaffold(
		/*topBar = {
			TopAppBar(title = { Text(text = "Movies") })
		}*/
	) { paddingValues ->
		Box(
			modifier = Modifier
				.background(Color.White)
				.fillMaxSize(),
		) {
			OutlinedTextField(
				value = "",
				onValueChange = {},
				placeholder = { Text(text = "Marka, ürün veya kategori ara") },
				leadingIcon = {
					Icon(
						painter = painterResource(id = R.drawable.ic_search),
						contentDescription = "Search"
					)
				},
				modifier = Modifier
					.fillMaxWidth()
					.padding(5.dp)
					.height(54.dp)
					.align(Alignment.TopCenter),
				singleLine = true,
				enabled = false
			)

			LazyColumn(
				modifier = Modifier
					.fillMaxSize()
					.padding(top = 72.dp)
			) {
				item {
					LazyRow(
						modifier = Modifier
							.fillMaxWidth()
							.padding(horizontal = 5.dp)
					) {
						items(count = storyList.count()) { index ->
							val menu = storyList[index]
							Card(
								modifier = Modifier
									.width((screenWidth / 6).dp)
									.padding(all = 5.dp),
								colors = CardDefaults.cardColors(
									containerColor = Color.White
								)
							) {
								Column(
									modifier = Modifier
										.fillMaxWidth(),
									horizontalAlignment = Alignment.CenterHorizontally,
									verticalArrangement = Arrangement.SpaceBetween
								) {
									val activity = LocalContext.current as Activity
									Image(
										bitmap = ImageBitmap.imageResource(
											id = activity.resources.getIdentifier(
												menu.image, "drawable", activity.packageName
											)
										), contentDescription = ""
									)
									Text(
										text = menu.name,
										fontSize = 12.sp,
										maxLines = 2,
										style = MaterialTheme.typography.displaySmall.copy(
											lineHeight = 12.sp,
										),
										textAlign = TextAlign.Center,
										overflow = TextOverflow.Ellipsis
									)
								}
							}
						}
					}
				}

				items(count = offerList.count()) { index ->
					val offermenu = offerList[index]
					Card(
						modifier = Modifier
							.padding(all = 5.dp),
						colors = CardDefaults.cardColors(
							containerColor = Color.White
						)
					) {
						val activity = LocalContext.current as Activity
						Image(
							modifier = Modifier
								.fillMaxSize(),
							bitmap = ImageBitmap.imageResource(
								id = activity.resources.getIdentifier(
									offermenu.image, "drawable", activity.packageName
								)
							),
							contentDescription = "",
							contentScale = ContentScale.Crop // Adjust the scale as needed
						)
					}
				}

			}
		}
	}
}


@Preview(
	showBackground = true
)
@Composable
fun FlowerPreview() {
	CiceksepetiTheme {
		FlowerScreen()
	}
}
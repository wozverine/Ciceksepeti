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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.rememberNavController
import com.glitch.ciceksepeti.R
import com.glitch.ciceksepeti.ui.theme.CiceksepetiTheme
import com.glitch.ciceksepeti.ui.theme.Green167

@Composable


fun CartScreen(
	navigateBack: () -> Unit
) {
	@Composable
	fun CustomTopAppBarNoPadding(title: String) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.White)
				.height(50.dp)
				.padding(0.dp)
		) {
			ConstraintLayout(
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 5.dp)
			)
			{
				val (text, backImage) = createRefs()
				Text(
					text = title,
					fontSize = 14.sp,
					color = Color.Black,
					textAlign = TextAlign.Center,
					modifier = Modifier
						.constrainAs(text) {
							top.linkTo(parent.top)
							bottom.linkTo(parent.bottom)
						}
						.padding(0.dp)
						.fillMaxWidth()
				)

				IconButton(onClick = navigateBack) {
					Icon(
						modifier = Modifier
							.constrainAs(backImage) {
								start.linkTo(parent.start)
								top.linkTo(parent.top)
								bottom.linkTo(parent.bottom)
							},
						imageVector = Icons.AutoMirrored.Filled.ArrowBack,
						contentDescription = "Back button",
						tint = Color.Black
					)
				}
			}
		}
	}

	Scaffold(
		topBar = {
			CustomTopAppBarNoPadding(title = stringResource(id = R.string.my_cart))
		},
		containerColor = Color.White
	) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues)
				.background(Color.White),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center

		) {
			Image(
				painter = painterResource(
					id = R.drawable.cart,
				),
				modifier = Modifier.padding(vertical = 10.dp),
				contentScale = ContentScale.Fit,
				contentDescription = ""
			)
			Text(
				text = stringResource(R.string.cart_empty),
				color = Color.Black,
			)
			Button(
				onClick = {
					navigateBack()
				}, colors = ButtonDefaults.buttonColors(
					containerColor = Green167,
				), shape = RoundedCornerShape(5.dp)
			) {
				Text(text = stringResource(id = R.string.start_shopping))
			}
		}
	}
}

@Preview(
	showBackground = true,
	locale = "tr"
)
@Composable
fun CartPreview() {
	CiceksepetiTheme {
		val navController = rememberNavController()
		CartScreen(navigateBack = { navController.popBackStack() })
	}
}
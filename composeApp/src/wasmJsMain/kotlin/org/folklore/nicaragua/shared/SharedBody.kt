package org.folklore.nicaragua.shared


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import folklore_nica_web.composeapp.generated.resources.Res
import folklore_nica_web.composeapp.generated.resources.image

import kotlinx.coroutines.launch
import org.folklore.nicaragua.theme.colorContent
import org.jetbrains.compose.resources.painterResource


@Composable
fun SharedBody(
    section1: @Composable (Modifier) -> Unit,
    section2: @Composable (Modifier) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        section1(Modifier.weight(1f))
        section2(Modifier.weight(1f))

    }
}

@Composable
fun SharedInformation(
    modifier: Modifier,
    title: String,
    paragraph1: String,
    paragraph2: String
) {
    Column(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title, color = colorContent, fontSize = 30.sp, fontWeight = FontWeight.W700
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = paragraph1,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Start
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = paragraph2,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Start
        )
    }
}


@Composable
fun SharedInformationPicture(
    picture1: String,
    picture2: String,
    modifier: Modifier,
    shape: RoundedCornerShape
) {
    Row(
        modifier = modifier.padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(300.dp)
                .background(color = Color.LightGray, shape = shape)
        ) {
            Image(
                painter = painterResource(Res.drawable.image),
                contentDescription = "Imagen 2",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(50.dp),

            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(top = 50.dp)
                .height(285.dp)
                .background(color = Color.LightGray, shape = shape)
        ) {
            Image(
                painter = painterResource(Res.drawable.image),
                contentDescription = "Imagen 2",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(50.dp),

            )
        }
    }
}

@Composable
fun SharedCarousel(
    picture: String,
    title: String,
    description: String,
) {
    Card(
        modifier = Modifier.width(370.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = painterResource(Res.drawable.image),
                    contentDescription = "Imagen 2",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(50.dp),

                    )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun SharedLazyRow(
    content: @Composable () -> Unit
) {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    LazyRow(
        state = scrollState,
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    coroutineScope.launch {
                        scrollState.scrollBy(-dragAmount)
                    }
                }
            },
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(20) {
            content()
        }
    }
}

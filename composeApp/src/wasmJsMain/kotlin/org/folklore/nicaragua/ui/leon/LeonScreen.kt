package org.folklore.nicaragua.ui.leon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import folklore_nica_web.composeapp.generated.resources.Res
import folklore_nica_web.composeapp.generated.resources.image
import org.folklore.nicaragua.shared.*
import org.folklore.nicaragua.theme.backgroundLeon
import org.folklore.nicaragua.theme.colorContent

import org.folklore.nicaragua.ui.leon.string.LeonTextResources
import org.jetbrains.compose.resources.painterResource

@Composable
fun LeonScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundLeon),
        contentAlignment = Alignment.Center
    ) {
        BodyLeon()
    }
}

@Composable
fun BodyLeon() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(35.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "León",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = colorContent,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        SharedBody(
            section1 = { modifier ->
                InformationLeon(modifier)
            },
            section2 = { modifier ->
                InformationPictureLeon(modifier)
            })
        Spacer(Modifier.height(20.dp))
        Carousel()
        Spacer(Modifier.height(20.dp))
        GallerySection()

    }
}

@Composable
fun LeonVideo() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(color = Color.LightGray, shape = RoundedCornerShape(10.dp))
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "", modifier = Modifier.size(50.dp))
        }
        Box(
            modifier = Modifier
                .height(200.dp)
                .background(color = Color.LightGray, shape = RoundedCornerShape(10.dp))
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "", modifier = Modifier.size(50.dp))
        }
    }

}

@Composable
fun GallerySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Galeria de León",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorContent,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        SharedLazyRow {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(10.dp))
            ){
                Image(
                    painter = painterResource(Res.drawable.image),
                    contentDescription = "Imagen 2",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(50.dp),

                    )
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Videos de León",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorContent,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        LeonVideo()
    }

}

@Composable
fun Carousel() {

    SharedLazyRow {
        SharedCarousel(
            picture = "",
            title = "La Gigantona",
            description = "Representación folclórica que consiste en una mujer de gran estatura que baila al ritmo del tambor y el chischil. Esta tradición se remonta a la época colonial y representa la burla del indígena hacia los españoles.",
        )
    }

}

@Composable
fun InformationPictureLeon(modifier: Modifier) {
    SharedInformationPicture(
        picture1 = "",
        picture2 = "",
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    )
}

@Composable
fun InformationLeon(modifier: Modifier) {
    SharedInformation(
        modifier = modifier,
        title = LeonTextResources.TITLE,
        paragraph1 = LeonTextResources.PARAGRAPH_1,
        paragraph2 = LeonTextResources.PARAGRAPH_2
    )
}

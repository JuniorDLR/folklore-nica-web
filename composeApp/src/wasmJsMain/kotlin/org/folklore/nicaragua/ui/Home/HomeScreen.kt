package org.folklore.nicaragua.ui.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.folklore.nicaragua.ui.Home.string.HomeTextResources
import org.folklore.nicaragua.theme.colorContent


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        contentMain()
        Spacer(Modifier.height(40.dp))
        bodyHome()
    }
}

@Composable
fun bodyHome() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Information(Modifier.weight(1f))
        InformationPicture(Modifier.weight(1f))

    }
}

@Composable
fun InformationPicture(modifier: Modifier) {

    val shape = RoundedCornerShape(10.dp)
    Row(
        modifier = modifier
            .padding(10.dp)
    ) {
        // Primer Box con altura mayor
        Box(
            modifier = Modifier
                .weight(1f)  // Para que ocupe el 50% del espacio horizontal disponible
                .height(160.dp)  // Altura mayor
                .background(color = Color.LightGray, shape = shape)
        ) {}

        // Espaciador para separar los Box
        Spacer(modifier = Modifier.width(10.dp))

        // Segundo Box con altura menor
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(top = 50.dp)// Para que ocupe el 50% del espacio horizontal disponible
                .height(160.dp)  // Altura menor
                .background(color = Color.LightGray, shape = shape)

        ) {}
    }
}


@Composable
fun Information(modifier: Modifier) {
    Column(
        modifier = modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = HomeTextResources.TITLE,
            color = colorContent,
            fontSize = 30.sp,
            fontWeight = FontWeight.W700
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = HomeTextResources.PARAGRAPH_1,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Start
        )
        Spacer(Modifier.height(15.dp))
        Text(
            text = HomeTextResources.PARAGRAPH_2,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Start
        )


    }
}

@Composable
fun contentMain() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(color = colorContent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),  // Agregar espacio a los márgenes
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            TitleMain(title = "Nica Folk: León y Chinandega")
            Spacer(modifier = Modifier.height(16.dp))
            DescriptionMain(description = "Descubre la riqueza cultural y tradiciones de estos dos departamentos de Nicaragua")
            Spacer(modifier = Modifier.height(16.dp))
            ButtonMain()
        }
    }
}

@Composable
fun TitleMain(title: String) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 45.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DescriptionMain(description: String) {
    Text(
        text = description,
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.W400
    )
}

@Composable
fun ButtonMain() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        ButtonDesign(buttonText = "Explorar", icon = Icons.AutoMirrored.Filled.ArrowForward)
        ButtonDesign(buttonText = "Ver video", icon = Icons.Default.PlayArrow)
    }
}

@Composable
fun ButtonDesign(buttonText: String, icon: ImageVector) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()

    val backgroundColor = if (isHovered.value) colorContent else Color.White
    val color = if (isHovered.value) Color.Black else colorContent
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = buttonText,
                color = color
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = icon,
                contentDescription = "Ícono",
                modifier = Modifier.size(20.dp),
                tint = color
            )
        }
    }
}

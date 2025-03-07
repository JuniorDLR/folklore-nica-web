package org.folklore.nicaragua.ui.home



import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.folklore.nicaragua.shared.SharedBody
import org.folklore.nicaragua.shared.SharedInformation
import org.folklore.nicaragua.shared.SharedInformationPicture
import org.folklore.nicaragua.theme.colorAnimation
import org.folklore.nicaragua.ui.home.string.HomeTextResources
import org.folklore.nicaragua.theme.colorContent
import org.folklore.nicaragua.ui.FolkViewModel
import org.folklore.nicaragua.ui.menu.Page


@Composable
fun HomeScreen(viewModel: FolkViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        contentMain(viewModel)
        Spacer(Modifier.height(10.dp))
        bodyHome()
    }
}

@Composable
fun bodyHome() {
    Box(modifier = Modifier.padding(35.dp), contentAlignment = Alignment.Center) {
        SharedBody(section1 = { modifier ->
            InformationHome(modifier)
        }, section2 = { modifier ->
            InformationPictureHome(modifier)
        })
    }
}

@Composable
fun InformationPictureHome(modifier: Modifier) {
    SharedInformationPicture(
        picture1 = "",
        picture2 = "",
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    )
}


@Composable
fun InformationHome(modifier: Modifier) {
    SharedInformation(
        modifier = modifier,
        title = HomeTextResources.TITLE,
        paragraph1 = HomeTextResources.PARAGRAPH_1,
        paragraph2 = HomeTextResources.PARAGRAPH_2
    )
}

@Composable
fun contentMain(viewModel: FolkViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(color = colorContent)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start
        ) {
            TitleMain(title = "Nica Folk: León y Chinandega")
            Spacer(modifier = Modifier.height(16.dp))
            DescriptionMain(description = "Descubre la riqueza cultural y tradiciones de estos dos departamentos de Nicaragua")
            Spacer(modifier = Modifier.height(10.dp))
            ButtonMain(viewModel)
            AnimationText(viewModel)
        }
    }
}

@Composable
fun AnimationText(viewModel: FolkViewModel) {
    val listObserved by remember { mutableStateOf(viewModel.animationText()) }
    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentIndex = (currentIndex + 1) % listObserved.size
        }
    }

    Box(
        modifier = Modifier
            .width(400.dp)
            .background(color = colorAnimation),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            text = listObserved.getOrNull(currentIndex) ?: "",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun TitleMain(title: String) {
    Text(
        text = title, color = Color.White, fontSize = 45.sp, fontWeight = FontWeight.Bold
    )
}

@Composable
fun DescriptionMain(description: String) {
    Text(
        text = description, color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.W400
    )
}

@Composable
fun ButtonMain(viewModel: FolkViewModel) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        ButtonDesign(buttonText = "Explorar León") {
            viewModel.changeNavigation(Page.LEON)
        }
        ButtonDesign(buttonText = "Explorar Chinandega") {
            viewModel.changeNavigation(Page.CHINANDEGA)
        }
    }
}

@Composable
fun ButtonDesign(buttonText: String, onClick: () -> Unit) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()

    val backgroundColor = if (isHovered.value) colorContent else Color.White
    val color = if (isHovered.value) Color.Black else colorContent
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = buttonText, color = color
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Ícono",
                modifier = Modifier.size(20.dp),
                tint = color
            )
        }
    }
}

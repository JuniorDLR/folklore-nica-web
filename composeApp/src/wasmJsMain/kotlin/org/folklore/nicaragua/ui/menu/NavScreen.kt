package org.folklore.nicaragua.ui.menu

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import folklore_nica_web.composeapp.generated.resources.Res
import folklore_nica_web.composeapp.generated.resources.logo
import org.folklore.nicaragua.theme.colorMain
import org.jetbrains.compose.resources.painterResource


@Composable
fun NavScreen(navigationOption: Page, newNavigation: (Page) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth().background(color = Color.White)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppHeader()
            NavigationMenu(newNavigation, navigationOption)

        }
    }
}

@Composable
fun NavigationMenu(newNavigation: (Page) -> Unit, navigationOption: Page) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ButtonDesign(
            selectionOption = navigationOption == Page.HOME,
            text = "Inicio",
            onClick = {
                newNavigation(Page.HOME)
            }
        )
        ButtonDesign(
            text = "León",
            onClick = {
                newNavigation(Page.LEON)
            },
            selectionOption = navigationOption == Page.LEON
        )
        ButtonDesign(
            text = "Chinandega",
            onClick = {
                newNavigation(Page.CHINANDEGA)
            },
            selectionOption = navigationOption == Page.CHINANDEGA
        )
        ButtonDesign(
            text = "Acerca de",
            onClick = {
                newNavigation(Page.ABOUT)
            },
            selectionOption = navigationOption == Page.ABOUT
        )
    }

}

@Composable
fun AppHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.clip(shape = CircleShape).size(50.dp)
        )
        Text(text = "Nica Folk", color = colorMain, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    }
}


@Composable
fun ButtonDesign(text: String, onClick: () -> Unit = {}, selectionOption: Boolean) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()


    val backgroundColor = when {
        selectionOption -> colorMain
        isHovered.value -> Color.Gray
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .hoverable(interactionSource = interactionSource)
    ) {
        Text(
            text = text,
            color = if (selectionOption) Color.White else Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

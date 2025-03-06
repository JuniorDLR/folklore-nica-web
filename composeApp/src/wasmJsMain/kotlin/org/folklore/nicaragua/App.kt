package org.folklore.nicaragua

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.folklore.nicaragua.ui.ChinandegaScreen
import org.folklore.nicaragua.ui.AboutScreen
import org.folklore.nicaragua.ui.Home.HomeScreen
import org.folklore.nicaragua.ui.LeonScreen
import org.folklore.nicaragua.ui.menu.NavScreen
import org.folklore.nicaragua.ui.menu.Page

@Composable
fun App() {
    var navigationOption by remember { mutableStateOf(Page.HOME) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {

            NavScreen(navigationOption) { newNavigation ->
                navigationOption = newNavigation
            }

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item {
                    ContentOption(navigationOption)
                }
            }

            FooterFolk()
        }
    }
}


@Composable
fun FooterFolk() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "© 2025 Nica Folk. Todos los derechos reservados.",
            style = MaterialTheme.typography.body2,
            color = Color.LightGray
        )
    }
}


@Composable
fun ContentOption(navigationOption: Page) {
    Crossfade(targetState = navigationOption) { targetState ->
        when (targetState) {
            Page.HOME -> HomeScreen()
            Page.LEON -> LeonScreen()
            Page.CHINANDEGA -> ChinandegaScreen()
            Page.ABOUT -> AboutScreen()
        }
    }

}

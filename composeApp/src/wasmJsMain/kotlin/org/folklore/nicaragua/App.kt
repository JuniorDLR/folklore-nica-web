package org.folklore.nicaragua

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.folklore.nicaragua.theme.colorContent
import org.folklore.nicaragua.ui.ChinandegaScreen
import org.folklore.nicaragua.ui.AboutScreen
import org.folklore.nicaragua.ui.FolkViewModel
import org.folklore.nicaragua.ui.home.HomeScreen
import org.folklore.nicaragua.ui.leon.LeonScreen
import org.folklore.nicaragua.ui.menu.NavScreen
import org.folklore.nicaragua.ui.menu.Page

@Composable
fun App(viewModel: FolkViewModel) {
    val navigationOption by viewModel.navigationOption.collectAsState()

    Scaffold(bottomBar = {
            FooterFolk()
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxWidth()) {
                NavScreen(navigationOption) { newNavigation ->
                    viewModel.changeNavigation(newNavigation)
                }

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        ContentOption(navigationOption, viewModel)
                    }
                }
            }
        }
    }
}


@Composable
fun FooterFolk() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorContent),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "© 2025 Nica Folk. Todos los derechos reservados.",
            style = MaterialTheme.typography.body2.copy(
                color = Color.White,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}


@Composable
fun ContentOption(navigationOption: Page, viewModel: FolkViewModel) {
    Crossfade(targetState = navigationOption) { targetState ->
        when (targetState) {
            Page.HOME -> HomeScreen(viewModel)
            Page.LEON -> LeonScreen()
            Page.CHINANDEGA -> ChinandegaScreen()
            Page.ABOUT -> AboutScreen()
        }
    }

}

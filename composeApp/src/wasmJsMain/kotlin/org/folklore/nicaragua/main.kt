package org.folklore.nicaragua

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.folklore.nicaragua.ui.FolkViewModel

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
   val  viewModel= FolkViewModel()
    ComposeViewport(document.body!!) {
        App(viewModel)
    }
}
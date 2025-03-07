package org.folklore.nicaragua.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.folklore.nicaragua.ui.menu.Page

class FolkViewModel : ViewModel() {

    private val _navigationOption = MutableStateFlow(value = Page.HOME)
    val navigationOption: StateFlow<Page> = _navigationOption


    fun changeNavigation(navigationOption: Page) {
        _navigationOption.value = navigationOption
    }

    fun animationText():List<String>{
        return listOf("Festividades","Tradición","Danza","Cultura","Musica")
    }

}
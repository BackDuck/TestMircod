package com.example.testmircod.utils.cicerone

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen

class CustomRouter : Router() {
    fun navigateToWithAdd(screen: Screen) {
        executeCommands(ForwardWithAdd(screen))
    }
}
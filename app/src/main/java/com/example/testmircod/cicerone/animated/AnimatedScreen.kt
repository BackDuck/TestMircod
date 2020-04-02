package com.example.testmircod.cicerone.animated

import ru.terrakok.cicerone.android.support.SupportAppScreen

class AnimatedScreen(
    screen: SupportAppScreen,
    val animEnter: Int = 0,
    val animExit: Int = 0,
    val popAnimEnter: Int = 0,
    val popAnimExit: Int = 0
) : ScreenDecorator(screen)
package com.example.testmircod.cicerone.animated

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.testmircod.utils.cicerone.ForwardWithAdd
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.*

open class AnimatedNavigator : SupportAppNavigator {

    private val fragmentManager: FragmentManager?
    private val activity: FragmentActivity
    private val containerId: Int

    constructor(activity: FragmentActivity, containerId: Int) : super(activity, containerId) {
        this.activity = activity
        this.fragmentManager = activity.supportFragmentManager
        this.containerId = containerId
    }

    constructor(activity: FragmentActivity, fragmentManager: FragmentManager?, containerId: Int) : super(
            activity,
            fragmentManager,
            containerId
    ) {
        this.activity = activity
        this.fragmentManager = fragmentManager
        this.containerId = containerId
    }


    override fun applyCommand(command: Command) {
        when(command){
            is Forward-> activityForward(command)
            is ForwardWithAdd -> forwardWithAdd(command)
            is Replace -> activityReplace(command)
            is BackTo -> backTo(command)
            is Back -> fragmentBack()
        }
    }

    override fun setupFragmentTransaction(
        command: Command?,
        currentFragment: Fragment?,
        nextFragment: Fragment?,
        fragmentTransaction: FragmentTransaction?
    ) {
        //  if (currentFragment != null) {
        when (command) {
            is Forward -> {
                val screen = command.screen
                if (screen is AnimatedScreen) {
                    fragmentTransaction?.setCustomAnimations(
                            screen.animEnter,
                            screen.animExit,
                            screen.popAnimEnter,
                            screen.popAnimExit
                    )
                }
            }
            is Replace -> {
                val screen = command.screen
                if (screen is AnimatedScreen) {
                    fragmentTransaction?.setCustomAnimations(
                            screen.animEnter,
                            screen.animExit,
                            screen.popAnimEnter,
                            screen.popAnimExit
                    )
                }
            }

            is ForwardWithAdd -> {
                val screen = command.screen
                if (screen is AnimatedScreen) {
                    fragmentTransaction?.setCustomAnimations(
                            screen.animEnter,
                            screen.animExit,
                            screen.popAnimEnter,
                            screen.popAnimExit
                    )
                }
            }
        }
        //  }
    }

    fun forwardWithAdd(command: ForwardWithAdd) {
        val screen = command.screen as SupportAppScreen
        val fragment = createFragment(screen)

        val fragmentTransaction = fragmentManager?.beginTransaction()

        setupFragmentTransaction(
                command,
                fragmentManager?.findFragmentById(containerId),
                fragment,
                fragmentTransaction
        )
        fragmentTransaction?.add(containerId, fragment)?.addToBackStack(screen.screenKey)?.commit()
    }

}
package com.example.testmircod.presentation.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import moxy.ktx.moxyPresenter
import com.example.testmircod.R
import com.example.testmircod.base.MoxyActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class RootActivity : MoxyActivity(),
    RootView {

    @Inject
    lateinit var presenterProvider: Provider<RootPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    @field:RootQualifier
    @field:Inject
    lateinit var navigatorHolder: NavigatorHolder

    @field:RootQualifier
    @field:Inject
    lateinit var navigator: Navigator

    override val layout = R.layout.activity_main
    override val containerId = R.id.container

    val PERMISSIONS_CODE = 111

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            ) {
                permission_notyf.visibility = View.VISIBLE
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                    PERMISSIONS_CODE
                )
            }
        } else {
            presenter.allPermissionsGranted()
        }
        presenter.onCreate(savedInstanceState != null)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSIONS_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    presenter.allPermissionsGranted()
                } else {
                    permission_notyf.visibility = View.VISIBLE
                }
                return
            }
            else -> {
                permission_notyf.visibility = View.VISIBLE
            }
        }
    }

}

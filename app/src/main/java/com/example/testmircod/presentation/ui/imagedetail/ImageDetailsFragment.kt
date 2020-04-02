package com.example.testmircod.presentation.ui.imagedetail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.image_details_fragment.*
import moxy.ktx.moxyPresenter
import com.example.testmircod.R
import com.example.testmircod.base.MoxyFragment
import javax.inject.Inject
import javax.inject.Provider


class ImageDetailsFragment : MoxyFragment(), ImageDetailsView {

    companion object {
        val IMAGE_KEY = "IMAGE_KEY"

        fun getInstance(image: String): ImageDetailsFragment {
            val fragment = ImageDetailsFragment()
            val arguments = Bundle()
            arguments.putString(IMAGE_KEY, image)
            fragment.arguments = arguments
            return fragment
        }
    }

    @Inject
    lateinit var presenterProvider: Provider<ImageDetailsPresenter>

    private var mMap: GoogleMap? = null

    fun getImage() = arguments?.getString(IMAGE_KEY, "")?:""

    private val presenter by moxyPresenter {
        presenterProvider.get()
    }

    override val layout = R.layout.image_details_fragment

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)

    }

    override fun showImage(image: String){
        progressBar3.visibility = View.VISIBLE
        Glide.with(requireContext())
            .load(image)
            .listener(object : RequestListener<Drawable?> {
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                  progressBar3.visibility = View.GONE

                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                   progressBar3.visibility = View.GONE
                    return true
                }
            })
            .into(image_container)
    }
}


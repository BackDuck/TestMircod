package com.example.testmircod.presentation.ui.venuedetails

import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.venue_details_fragment.*
import moxy.ktx.moxyPresenter
import com.example.testmircod.R
import com.example.testmircod.base.MoxyFragment
import com.example.testmircod.presentation.model.VenueModel
import javax.inject.Inject
import javax.inject.Provider


class VenueDetailsFragment : MoxyFragment(), VenueDetailsView, OnMapReadyCallback {

    companion object {
        val MODEL_KEY = "MODEL_KEY"

        fun getInstance(venueModel: VenueModel): VenueDetailsFragment {
            val fragment = VenueDetailsFragment()
            val arguments = Bundle()
            arguments.putSerializable(MODEL_KEY, venueModel)
            fragment.arguments = arguments
            return fragment
        }
    }

    @Inject
    lateinit var presenterProvider: Provider<VenueDetailsPresenter>

    private var mMap: GoogleMap? = null

    fun getVenueModel() = arguments?.getSerializable(MODEL_KEY) as VenueModel

    private val presenter by moxyPresenter {
        presenterProvider.get()
    }

    override val layout = R.layout.venue_details_fragment

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)

        floatingActionButton.setOnClickListener {
            presenter.onClearCacheClick()
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        presenter.mapIsReady()
    }

    override fun showVenueDetails(details: VenueModel) {
        name_field.text = details.name
        distance.text =
            StringBuilder().append("Расстояние ").append(details.distance.toString()).append("м.")
        postal_code.text = if(details.postcode.isBlank()) "Неизвестно" else details.postcode
        address.text = if(details.address.isBlank()) "Неизвестно" else details.address

        viewPager.adapter = VenueDetailsPhotoViewPager(
            if (details.photos.isNotEmpty()) {
                details.photos to false
            } else {
                listOf(details.categoryIcon) to true
            }
        ) { image -> presenter.onImageClick(image)}
    }

    override fun showPositionOnMap(lat: Double, lon: Double, name: String) {
        val marker = LatLng(lat, lon)
        mMap?.addMarker(MarkerOptions().position(marker).title(name))
        mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 17f))
    }


}


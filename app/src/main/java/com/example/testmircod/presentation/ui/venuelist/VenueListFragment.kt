package com.example.testmircod.presentation.ui.venuelist

import android.location.Location
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.venue_list_fragment.*
import moxy.ktx.moxyPresenter
import com.example.testmircod.R
import com.example.testmircod.base.MoxyFragment
import com.example.testmircod.presentation.model.VenueModel
import javax.inject.Inject
import javax.inject.Provider

class VenueListFragment : MoxyFragment(), VenueListView {

    companion object {
        fun getInstance() = VenueListFragment()
    }

    @Inject
    lateinit var presenterProvider: Provider<VenueListPresenter>

    @Inject
    lateinit var adapter: VenueRecyclerviewAdapter

    lateinit var fusedLocationClient: FusedLocationProviderClient

    private val presenter by moxyPresenter {
        presenterProvider.get()
    }

    override val layout = R.layout.venue_list_fragment

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        requestLocation()

        floatingActionButton.setOnClickListener {
            presenter.onClearCacheClick()
        }

        initRecycler()
        refresh.setOnRefreshListener {
            presenter.refresh()
            refresh.isRefreshing = false
        }
    }

    override fun showVenues(items: List<VenueModel>) {
        adapter.items = items
    }

    override fun requestLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            presenter.locationReady(location?.latitude, location?.longitude)
        }
    }

    override fun showProgress() {
        venue_list.visibility = View.GONE
        progressBar2.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        venue_list.visibility = View.VISIBLE
        progressBar2.visibility = View.GONE
    }

    private fun initRecycler() {
        venue_list.layoutManager = LinearLayoutManager(requireContext())
        venue_list.adapter = adapter
        adapter.listener = { presenter.onVenueClick(it) }
    }

}


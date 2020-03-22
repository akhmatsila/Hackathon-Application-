package com.jsonstatham.hackathonapp.ui.Main.Search

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.graphics.alpha
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import com.jsonstatham.hackathonapp.Models.Status
import com.jsonstatham.hackathonapp.R
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import dagger.android.support.DaggerFragment
import java.util.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : DaggerFragment(), OnMapReadyCallback {

    private lateinit var navController: NavController
    private lateinit var processButton: Button
    private lateinit var bussinesText: TextView
    private lateinit var marker: Marker
    private lateinit var adressText: TextView
    private lateinit var progressBar: ProgressBar


    @Inject
    lateinit var factory: ViewModelProvider.Factory


    private lateinit var viewModel: SearchViewModel

    private lateinit var googleMap: GoogleMap


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        processButton = view.findViewById(R.id.analyze_button)
        bussinesText = view.findViewById(R.id.bussiness_type)
        navController = view.findNavController()
        adressText = view.findViewById(R.id.address)
        progressBar = view.findViewById(R.id.progress_bar)

        viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel::class.java)



        viewModel.getAnalyzis().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(view.context, it.message, Toast.LENGTH_LONG).show()
                }
                Status.EVALUATED -> {
                    progressBar.visibility = View.GONE
                    navController.navigate(R.id.action_searchFragment_to_detailFragment)
                }
                Status.EVALUATING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.NOTHING -> {
                }
            }
        })
        viewModel.getAdress().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.EVALUATED -> {
                    adressText.text = it.data!!.answer
                }
                Status.ERROR -> {
                    adressText.text = it.message
                }
                Status.EVALUATING -> {
                    adressText.text = "..."
                }
                else -> {
                }
            }
        })


        val mapFragment: SupportMapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



        processButton.setOnClickListener {
            viewModel.getZoneAnalytics(
                marker.position.latitude.toString(),
                marker.position.longitude.toString(),
                bussinesText.text.toString().toLowerCase(Locale.getDefault()))
        }

    }

    override fun onPause() {
        super.onPause()
        viewModel.stopWorking()
    }

    override fun onMapReady(p0: GoogleMap?) {
        googleMap = p0!!
        val position: LatLng = LatLng(59.916087, 30.318972)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 12f))
        googleMap.setOnMapClickListener {

            googleMap.clear()
            marker = googleMap.addMarker(MarkerOptions().position(it))
            googleMap.addCircle(
                CircleOptions().strokeWidth(0f).center(it).radius(500.0)
                    .fillColor(Color.argb(50, 0, 255, 0))
            )
            viewModel.getMarkeredAdress(
                marker.position.latitude.toString(),
                marker.position.longitude.toString()
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setCat(v : View) {
        bussinesText.text = (v as ImageView).autofillHints[0]!!
    }


}

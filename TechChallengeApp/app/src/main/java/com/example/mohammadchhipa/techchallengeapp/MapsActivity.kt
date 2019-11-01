package com.example.mohammadchhipa.techchallengeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mohammadchhipa.techchallengeapp.databinding.ItemDetailsBinding
import com.example.mohammadchhipa.techchallengeapp.di.Injectable
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.utils.AppConstant
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject

class MapsActivity : AppCompatActivity(), Injectable, OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var binding: ItemDetailsBinding
    lateinit var deliveryData: DeliveryData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.item_details)
        if (intent.hasExtra(AppConstant.DATA)) {
            deliveryData = intent.getSerializableExtra(AppConstant.DATA) as DeliveryData
        }
        binding.viewModel = deliveryData
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setTitle(getString(R.string.delivery_details))
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val location = LatLng(deliveryData.lat, deliveryData.lng)
        mMap.addMarker(MarkerOptions().position(location).title(deliveryData.description))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 18f))
    }
}

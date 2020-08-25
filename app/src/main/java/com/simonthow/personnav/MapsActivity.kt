package com.simonthow.personnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
// Add Marker to leeds beckett university
        val leedsbeckett = LatLng(53.827997, -1.592928)
        map.addMarker(MarkerOptions().position(leedsbeckett).title("Leeds Beckett University"))


        val jamesgraham = LatLng(53.827434, -1.592902)
        map.addMarker(MarkerOptions().position(jamesgraham).title("James Graham Building"))
        val carnegiehall = LatLng(53.828180, -1.595230)
        map.addMarker(MarkerOptions().position(carnegiehall).title("James Graham Building"))

        // Right Building
        val caedmonhall = LatLng(53.826963, -1.591790)
        map.addMarker(MarkerOptions().position(caedmonhall).title("Caedmon Hall"))
        val priestlyHall= LatLng(53.826997, -1.590721)
        map.addMarker(MarkerOptions().position(priestlyHall).title("Priestley Hall"))
        val foodcourt = LatLng(53.827581, -1.591283)
        map.addMarker(MarkerOptions().position(foodcourt).title("The Food Court"))
        val macaulayhall= LatLng(53.826388, -1.590711)
        map.addMarker(MarkerOptions().position(macaulayhall).title("Macaulay Hall"))
        val BrontëHall= LatLng(53.825997, -1.591293)
        map.addMarker(MarkerOptions().position(BrontëHall).title("Brontë Hall"))
        val LeightonHall= LatLng(53.826320, -1.591792)
        map.addMarker(MarkerOptions().position(LeightonHall).title("Leighton Hall"))

        //Left Buildings
        val grange= LatLng(53.825930, -1.594166)
        map.addMarker(MarkerOptions().position(grange).title("The Grange"))
        val cavendishhall= LatLng(53.826432, -1.594018)
        map.addMarker(MarkerOptions().position(cavendishhall).title("Cavandish Hall"))
        val fairfaxhall= LatLng(53.826934, -1.594148)
        map.addMarker(MarkerOptions().position(fairfaxhall).title("Fairfax Hall"))



        val zoomLevel = 16.0f //This goes up to 21
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(leedsbeckett, zoomLevel))
        setMapLongClick(map)


    }
    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener { latLng ->
            map.addMarker(
                MarkerOptions()
                    .position(latLng)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.map_options, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            map.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}
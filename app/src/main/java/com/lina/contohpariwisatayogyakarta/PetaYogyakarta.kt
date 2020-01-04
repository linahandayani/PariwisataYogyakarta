package com.lina.contohpariwisatayogyakarta

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import android.Manifest

class PetaYogyakarta : Fragment(), OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, GoogleMap.OnMarkerClickListener {


    lateinit var tugu_jogja: LatLng
    lateinit var keraton: LatLng
    lateinit var monumen_jogja_kembali: LatLng
    lateinit var museum_gunung_merapi: LatLng
    lateinit var tamansari: LatLng
    lateinit var bunker_kaliadem: LatLng
    lateinit var parangtritis: LatLng
    lateinit var candi_prambanan: LatLng
    lateinit var pantai_jungwok: LatLng
    lateinit var malioboro: LatLng
    lateinit var candi_ijo: LatLng

    override fun onMarkerClick(p0: Marker?): Boolean {
        val lokasi = p0?.getTitle()
        if (lokasi.equals("Tugu Jogja")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Tittle", "Tugu Jogja")
            intent?.putExtra("URL", "https://goo.gl/maps/yx1kcro8saVWpk4s8\"")
            intent?.putExtra("Detail", getString(R.string.tugu_jogja))
            startActivity(intent)
        } else if (lokasi.equals("Keraton")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Keraton Yogyakarta")
            intent?.putExtra("URL", "https://goo.gl/maps/4g7HmvJkn9difXbH8")
            intent?.putExtra("Detail", getString(R.string.keraton_jogja))
            startActivity(intent)
        } else if (lokasi.equals("Monumen Jogja Kembali")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Monumen Jogja Kembali")
            intent?.putExtra("URL", "https://goo.gl/maps/Rfqgpj3pcLf5s8YR9")
            intent?.putExtra("Detail", getString(R.string.monumen_jogja))
            startActivity(intent)
        } else if (lokasi.equals("Museum Gunung Merapi")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Museum Gunung Merapi")
            intent?.putExtra("URL", "https://goo.gl/maps/xP7dc9HrhxyVDXFZ8")
            intent?.putExtra("Detail", getString(R.string.monumen_jogja))
            startActivity(intent)
        } else if (lokasi.equals("Taman Sari")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Museum Gunung Merapi")
            intent?.putExtra("URL", "https://goo.gl/maps/fWZDsq8CrCgcGdyQA")
            intent?.putExtra("Detail", getString(R.string.taman_sari))
            startActivity(intent)
        } else if (lokasi.equals("Bunker Kaliadem")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Museum Gunung Merapi")
            intent?.putExtra("URL", "https://goo.gl/maps/UgFQHB5yHwcrE19M8")
            intent?.putExtra("Detail", getString(R.string.bunker_kaliadem))
            startActivity(intent)
        } else if (lokasi.equals("Parangtritis")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Parangtritis")
            intent?.putExtra("URL", "https://goo.gl/maps/yQnhQnhZcnUeZKev9")
            intent?.putExtra("Detail", getString(R.string.parangtritis))
            startActivity(intent)
        } else if (lokasi.equals("Candi Prambanan")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Candi Prambanan")
            intent?.putExtra("URL", "https://goo.gl/maps/SX8Ypjndyod15CKu5")
            intent?.putExtra("Detail", getString(R.string.candi_prambanan))
            startActivity(intent)
        } else if (lokasi.equals("Pantai Jungwok")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Pantai Jungwok")
            intent?.putExtra("URL", "https://goo.gl/maps/V4KgjGHtAckYNZGb7")
            intent?.putExtra("Detail", getString(R.string.pantai_jungwok))
            startActivity(intent)
        } else if (lokasi.equals("Malioboro")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Malioboro")
            intent?.putExtra("URL", "https://goo.gl/maps/Myqr6GLp6DQE5rqq5")
            intent?.putExtra("Detail", getString(R.string.malioboro))
            startActivity(intent)
        } else if (lokasi.equals("Candi Ijo")) {
            val intent = Intent(activity, DetailObjekWisata::class.java)
            intent?.putExtra("Title", "Malioboro")
            intent?.putExtra("URL", "https://goo.gl/maps/A9ZvYbTtHP5EMXyL6")
            intent?.putExtra("Detail", getString(R.string.candi_ijo))
            startActivity(intent)
        } else {
        }
        return true

    }

    override fun onMyLocationClick(p0: Location) {
    }

    override fun onMyLocationButtonClick(): Boolean {
        return false
    }

    //FUNGSI ONclick:
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_Normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.button_satelit -> {
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
        }
    }

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment
    lateinit var normal: Button
    lateinit var satelit: Button

    override fun onMapReady(p0: GoogleMap?) {
        map = p0!!
        val permission = this.context?.let {
            ContextCompat.checkSelfPermission(
                it,
                //perhatikan import jika permission salah
                Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (permission == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true)
            map.setOnMyLocationButtonClickListener(this)
            map.setOnMyLocationClickListener(this)
            map.uiSettings.setZoomControlsEnabled(true)
        }

        tugu_jogja = LatLng(-7.7759483, 110.3501273)
        map.addMarker(MarkerOptions().position(tugu_jogja).title("Tugu Jogja"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tugu_jogja, 10F))

        keraton = LatLng(-7.8052792, 110.3620144)
        map.addMarker(MarkerOptions().position(keraton).title("Keraton"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(keraton, 10F))

        monumen_jogja_kembali = LatLng(-7.7495851, 110.3674181)
        map.addMarker(MarkerOptions().position(monumen_jogja_kembali).title("Monumen Yogya Kembali"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(keraton, 10F))

        museum_gunung_merapi = LatLng(-7.6159384, 110.4221828)
        map.addMarker(MarkerOptions().position(museum_gunung_merapi).title("Museum Gunung Merapi"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(museum_gunung_merapi, 10F))

        tamansari = LatLng(-7.8100839, 110.3572566)
        map.addMarker(MarkerOptions().position(tamansari).title("Taman Sari"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tamansari, 10F))

        parangtritis = LatLng(-8.0255145, 110.3199843)
        map.addMarker(MarkerOptions().position(parangtritis).title("Pantai Parang Tritis"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(parangtritis, 10F))

        candi_prambanan = LatLng(-7.5829145, 110.4454929)
        map.addMarker(MarkerOptions().position(candi_prambanan).title("Candi Prambanan"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(candi_prambanan, 10F))

        pantai_jungwok = LatLng(-8.1980253, 110.7102276)
        map.addMarker(MarkerOptions().position(pantai_jungwok).title("Pantai Jungwok"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_jungwok, 10F))

        malioboro = LatLng(-7.794311, 110.3634155)
        map.addMarker(MarkerOptions().position(malioboro).title("Malioboro"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(malioboro, 10F))

        candi_ijo = LatLng(-7.7838266, 110.5096661)
        map.addMarker(MarkerOptions().position(candi_ijo).title("Candi Ijo"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(candi_ijo, 10F))

        val builder = LatLngBounds.Builder()
        builder.include(tugu_jogja)
        builder.include(keraton)
        builder.include(monumen_jogja_kembali)
        builder.include(museum_gunung_merapi)
        builder.include(tamansari)
        builder.include(parangtritis)
        builder.include(candi_prambanan)
        builder.include(pantai_jungwok)
        builder.include(malioboro)
        builder.include(candi_ijo)
        val bounds = builder.build()
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))

        map.setOnMarkerClickListener(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       activity?.setTitle("Peta Yogyakarta")
        return inflater.inflate(R.layout.activity_peta_yogyakarta, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mp= childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)
        normal=view.findViewById(R.id.button_Normal)
        satelit=view.findViewById(R.id.button_satelit)

        normal.setOnClickListener(this)
        satelit.setOnClickListener(this)
    }



}

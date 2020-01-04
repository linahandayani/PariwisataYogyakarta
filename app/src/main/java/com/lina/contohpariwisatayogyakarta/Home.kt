package com.lina.contohpariwisatayogyakarta

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
//import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*

//tanda !! jika null dia force close
//? sama utk menghindari eror coding
class Home : Fragment(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_objekwisata -> {
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container, ObjekWisata())?.commit()

                //jika nav_view error tambahkan import kotlinx main.activity
                //nav_view ke activity_main
                activity?.nav_view
                    ?.menu?.getItem(1)?.isChecked = true
            }
        }
    }

    lateinit var carouselView: CarouselView
    lateinit var btn_profile: ImageView
    lateinit var btn_portal: ImageView
    lateinit var btn_lokasi: ImageView
    lateinit var btn_video: ImageView
    lateinit var btn_galeri: ImageView
    lateinit var btn_tentang: ImageView
    val sampleImage = intArrayOf(
        R.drawable.tugu_2, R.drawable.image_1, R.drawable.image_2,
        R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,
        R.drawable.image_7, R.drawable.tamansari, R.drawable.pantai_timang,
        R.drawable.museum_gunung_merapi, R.drawable.malioboro, R.drawable.candi_ijo
    )

    //dipanggil saat fragment siap membaca layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle("Wisata Yogyakarta")
        val view: View
        //ini cara mengembangkan ViewGroup cara
        view = inflater.inflate(R.layout.activity_home, null)
        carouselView = view.findViewById(R.id.carouselView)
        carouselView.setPageCount(11)
        carouselView.setImageListener(imageListener)
        carouselView.setImageClickListener { position ->
            if (position == 0) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Tugu Jogja")
                intent?.putExtra("URL", "https://goo.gl/maps/yx1kcro8saVWpk4s8")
                intent?.putExtra("Detail", getString(R.string.tugu_jogja))
                startActivity(intent)
            } else if (position == 1) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Keraton Yogyakarta")
                intent?.putExtra("URL", "https://goo.gl/maps/4g7HmvJkn9difXbH8")
                intent?.putExtra("Detail", getString(R.string.keraton_jogja))
                startActivity(intent)
            } else if (position == 2) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Monumen Jogja Kembali")
                intent?.putExtra("URL", "https://goo.gl/maps/Rfqgpj3pcLf5s8YR9")
                intent?.putExtra("Detail", getString(R.string.monumen_jogja))
                startActivity(intent)
            } else if (position == 3) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Museum Gunung Merapi")
                intent?.putExtra("URL", "https://goo.gl/maps/xP7dc9HrhxyVDXFZ8")
                intent?.putExtra("Detail", getString(R.string.keraton_jogja))
                startActivity(intent)
            } else if (position == 4) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Taman Sari")
                intent?.putExtra("URL", "https://goo.gl/maps/fWZDsq8CrCgcGdyQA")
                intent?.putExtra("Detail", getString(R.string.taman_sari))
                startActivity(intent)
            } else if (position == 5) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Bunker Kaliadem")
                intent?.putExtra("URL", "https://goo.gl/maps/UgFQHB5yHwcrE19M8")
                intent?.putExtra("Detail", getString(R.string.bunker_kaliadem))
                startActivity(intent)
            } else if (position == 6) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Parangtritis")
                intent?.putExtra("URL", "https://goo.gl/maps/yQnhQnhZcnUeZKev9")
                intent?.putExtra("Detail", getString(R.string.parangtritis))
                startActivity(intent)
            } else if (position == 7) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Candi Prambanan")
                intent?.putExtra("URL", "https://goo.gl/maps/SX8Ypjndyod15CKu5")
                intent?.putExtra("Detail", getString(R.string.candi_prambanan))
                startActivity(intent)
            } else if (position == 8) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Pantai Jungwok")
                intent?.putExtra("URL", "https://goo.gl/maps/V4KgjGHtAckYNZGb7")
                intent?.putExtra("Detail", getString(R.string.pantai_jungwok))
                startActivity(intent)
            } else if (position == 9) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Malioboro")
                intent?.putExtra("URL", "https://goo.gl/maps/Myqr6GLp6DQE5rqq5")
                intent?.putExtra("Detail", getString(R.string.malioboro))
                startActivity(intent)
            } else if (position == 10) {
                val intent = Intent(activity, DetailObjekWisata::class.java)
                intent?.putExtra("Title", "Candi Ijo")
                intent?.putExtra("URL", "https://goo.gl/maps/A9ZvYbTtHP5EMXyL6")
                intent?.putExtra("Detail", getString(R.string.candi_ijo))
                startActivity(intent)
            } else {
            }
        }
        return view
    }

    //Glide merah
    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@Home).load(sampleImage[position]).into(imageView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_profile = view.findViewById(R.id.button_objekwisata)
        btn_lokasi = view.findViewById(R.id.button_lokasiwisata)
        btn_portal = view.findViewById(R.id.button_web)
        btn_video = view.findViewById(R.id.button_video)
        btn_galeri = view.findViewById(R.id.button_galeriwisata)
        btn_tentang = view.findViewById(R.id.button_tentang)

        btn_profile.setOnClickListener(this)
        btn_lokasi.setOnClickListener(this)
        btn_portal.setOnClickListener(this)
        btn_video.setOnClickListener(this)
        btn_galeri.setOnClickListener(this)
        btn_tentang.setOnClickListener(this)
    }
}

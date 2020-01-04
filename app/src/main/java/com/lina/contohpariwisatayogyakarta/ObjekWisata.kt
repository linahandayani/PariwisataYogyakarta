package com.lina.contohpariwisatayogyakarta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class ObjekWisata : Fragment() {
lateinit var carouselView: CarouselView

    val sampleImages= intArrayOf(R.drawable.tugu_2, R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4,
        R.drawable.image_5, R.drawable.image_6, R.drawable.image_7, R.drawable.tamansari, R.drawable.pantai_timang,
        R.drawable.museum_gunung_merapi, R.drawable.malioboro, R.drawable.candi_ijo)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle("Wisata Yogyakarta")
        val view: View
        view = inflater.inflate(R.layout.activity_objek_wisata, null)
        carouselView=view.findViewById(R.id.carouselView)
        carouselView.setPageCount(13)
        carouselView.setImageListener(imageListener)
        return view
    }

    var imageListener: ImageListener = object : ImageListener{
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@ObjekWisata).load(sampleImages[position]).into(imageView)
        }
    }

}

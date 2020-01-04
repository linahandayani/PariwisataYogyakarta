package com.lina.contohpariwisatayogyakarta

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.ImageView
import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_detail__objek__wisata.*
import kotlinx.android.synthetic.main.my_toolbar.*

class DetailObjekWisata : AppCompatActivity() {
    lateinit var tv_title: TextView
    lateinit var tv_detail: TextView
    lateinit var iv_gmbr: ImageView
    private var fab: FloatingActionButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__objek__wisata)
        //jika tToobar error, pada import tambahkan my_toobar saja
        setSupportActionBar(tToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        iv_gmbr = findViewById(R.id.iv_gambar) as ImageView
        tv_title = findViewById(R.id.tv_judul)
        tv_detail = findViewById(R.id.tv_penjelasan)
        var t: String = intent.getStringExtra("Title")
        var d: String = intent.getStringExtra("Detail")
        var url: String = intent.getStringExtra("URL")
        supportActionBar?.title =t

        tv_title.setText(t)
        tv_detail.setText(d)
        var a = tv_title.text
        if (a == "Tugu Jogja") {
            iv_gmbr.setImageResource(R.drawable.tugu_2)
        } else if (a == "Keraton Yogyakarta") {
            iv_gmbr.setImageResource(R.drawable.image_3)
        } else if (a == "Monumen Jogja Kembali") {
            iv_gmbr.setImageResource(R.drawable.image_6)
        } else if (a == "Museum Gunung Merapi") {
            iv_gmbr.setImageResource(R.drawable.museum_gunung_merapi)
        } else if (a == "Taman Sari") {
            iv_gmbr.setImageResource(R.drawable.tamansari)
        } else if (a == "Bunker Kaliadem") {
            iv_gmbr.setImageResource(R.drawable.image_1)
        } else if (a == "Parangtritis") {
            iv_gmbr.setImageResource(R.drawable.image_5)
        }else if (a == "Candi Prambanan") {
            iv_gmbr.setImageResource(R.drawable.image_4)
        }else if (a == "Pantai Jungwok") {
            iv_gmbr.setImageResource(R.drawable.image_2)
        } else if (a == "Malioboro") {
            iv_gmbr.setImageResource(R.drawable.malioboro)
        } else if (a == "Candi Ijo") {
            iv_gmbr.setImageResource(R.drawable.candi_ijo)
        }else{
            iv_gmbr.setImageResource(R.drawable.tugujogja)
        }
        fab = findViewById(R.id.fab) as FloatingActionButton
        fab!!.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                        Uri.parse(url)
                    )
                startActivity(intent)
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }

package com.lina.contohpariwisatayogyakarta

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class VideoWisata : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    lateinit var yb:YouTubePlayerView

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
        p1!!.setFullscreen(true)
        p1.cueVideo("ga-Fi7LiQlo")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_wisata)
        yb=findViewById(R.id.youtubePlayer)
        yb.initialize("AIzaSyAr6lJs44JErWcMS8M_afW80XASho8U_2M",this)
        requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }
    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        if (p1!!.isUserRecoverableError){
            p1.getErrorDialog(this,1).show()
        }
    }
    
}

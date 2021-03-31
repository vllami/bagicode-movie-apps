package com.bagicode.movee

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<MovieModel>("data")
        // "data" didapatkan dari adapter pada MainActivity, jadi pastikan ketika mengirim data dari intent putExtra
        // itu nama field/parameter itu sama.. jika tidak sama, outputnya null atau datanya tidak ada

        // Menampilkan data text
        if (data != null) {
            tv_title.text = data.title
            tv_genre.text = data.genre
            tv_desc.text = data.desc
        }

        // Menampilkan data video
        if (data != null) {
            videoView.setVideoURI(Uri.parse("android.resource://$packageName/${data.trailer}"))
        }
        videoView.start()

        // Mengontrol data video
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

    }
}
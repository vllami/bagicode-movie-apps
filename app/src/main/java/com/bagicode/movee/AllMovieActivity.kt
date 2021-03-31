package com.bagicode.movee

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_all_movie.*

class AllMovieActivity : AppCompatActivity() {

    // Menggunakan Basic Activity -> Layout ada 2, Activity dan Content
    // Jadi layout Content dipanggil di dalam ActivityAllMovie dengan perintah include didalamnya

    private var dataList = ArrayList<MovieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movie)
        setSupportActionBar(findViewById(R.id.toolbar))

        dataList = intent.getParcelableArrayListExtra("data")!!

        rv_all_movie.layoutManager = LinearLayoutManager(this)

        // Set adapter
        rv_all_movie.adapter = AllMovieAdapter(dataList) {
            // Sama seperti adapter pada MainActivity, jika di-klik.. akan ke DetailActivity
            // Bedanya, disini dibuat adapter yang memang ditujukan untuk menampilkan data vertical
            // Jadi harus membuat adapter yang sesuai dengan item-nya
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }
    }
}
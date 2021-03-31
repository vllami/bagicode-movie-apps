package com.bagicode.movee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dataList = ArrayList<MovieModel>()

    // Untuk membuat RecyclerView, membutuhkan item dan adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Memanggil data, View, dan Adapter

        // Pertama, membuat tipe dari RecyclerView-nya.. Karena pada layout-nya adalah Horizontal..
        // Maka inisialisasi untuk Horizontal
        rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        loadDataSample()

        rv_movie.adapter = MovieAdapter(dataList) {
            // Karena sudah membuat MainActivity yang menampilkan list, sekarang membuat Intent..
            // Karena sudah menggunakan parcelable, jadi bisa langsung mengirim data list ke DetailActivity
            // Disini mengambil sesuai informasi yang di-klik, misal meng-klik suatu film.. maka akan mengambil
            // data yang posisinya sesuai, kemudian dikirim ke DetailActivity
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }

        tv_view_all_movie.setOnClickListener {
            val intent = Intent(this, AllMovieActivity::class.java)
                .putExtra("data", dataList)
            startActivity(intent)
        }
    }

    private fun loadDataSample() {
        // Memanggil data
        dataList.add(
            MovieModel(
                // Menambahkan sesuai data yang dibuat
                "1",
                "Ad Astra",
                "Seorang astronot melakukan perjalanan ke tepi luar tata surya untuk menemukan ayahnya dan " +
                        "mengungkap misteri yang mengancam kelangsungan hidup planet kita. Dia mengungkap rahasia " +
                        "yang menantang sifat keberadaan manusia dan tempat kita di kosmos.",
                "Cerita Fiksi, Drama",
                R.drawable.ic_ad_astra,
                R.raw.video_sample,
                4.0F
            )
        )

        dataList.add(
            MovieModel(
                // Menambahkan sesuai data yang dibuat
                "2",
                "Sonic the Hedgehog",
                "Mengisahkan petualangan Sonic saat ia belajar tentang kompleksitas kehidupan di bumi " +
                        "bersama manusia sahabat barunya, Tom Wachowski. Sonic dan Tom bersatu untuk menghentikan " +
                        "si jahat Dr. Robotnik yang ingin menangkap Sonic dan menggunakan kekuatan istimewanya " +
                        "untuk menguasai dunia.",
                "Aksi, Cerita Fiksi, Komedi, Keluarga",
                R.drawable.ic_poster_sonic,
                R.raw.video_sonic,
                3.0F
            )
        )

        dataList.add(
            MovieModel(
                // Menambahkan sesuai data yang dibuat
                "3",
                "A Rainy Day in New York",
                "Dua orang muda tiba di New York untuk menghabiskan akhir pekan, tetapi begitu mereka tiba," +
                        "mereka bertemu dengan cuaca buruk dan serangkaian petualangan.",
                "Komedi, Percintaan",
                R.drawable.ic_poster_a_rainy_day_in_new_york,
                R.raw.video_a_rainy_day,
                5.0F
            )
        )

        dataList.add(
            MovieModel(
                // Menambahkan sesuai data yang dibuat
                "4",
                "Avengers: Endgame",
                "Terdampar di luar angkasa tanpa persediaan makanan dan minuman, Tony Stark berusaha " +
                        "mengirim pesan untuk Pepper Potts dimana persediaan oksigen mulai menipis. Sementara " +
                        "itu para Avengers yang tersisa harus menemukan cara untuk mengembalikan 50% mahluk di " +
                        "seluruh dunia yang telah dilenyapkan oleh Thanos.",
                "Petualangan, Cerita Fiksi, Aksi",
                R.drawable.ic_avengers,
                R.raw.video_sample,
                4.5F
            )
        )
    }
}
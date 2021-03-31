package com.bagicode.movee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(
    /**
     * Sebelum membuat List yang ada Model untuk dipakai, buat dulu Model-nya
     *
     * Kepalanya itu ada 2, yaitu:
     * - data (untuk data-nya)
     * - listener (untuk di-klik)
     */
    private var data: List<MovieModel>, // Menggunakan List yang ada Model-nya, Model yang dipakai adalah MovieModel
    private val listener: (MovieModel) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    // Membuat variable contextAdapter yang nanti akan dipakai
    private lateinit var contextAdapter: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        // onCreateViewHolder() -> Inisialisasi untuk View-nya

        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context

        val inflaterView: View =
            layoutInflater.inflate(R.layout.item_movie_horizontal, parent, false)
        return MovieViewHolder(inflaterView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // onBindViewHolder() -> Menggabungkan class MovieViewHolder dan Adapter contextAdapter

        // Setelah diinisialisasi dan ditampilkan, tinggal mengirim data dan listener-nya
        holder.bindItem(data[position], listener, contextAdapter, position)
    }

    override fun getItemCount(): Int = data.size // Ukuran data yang akan dilakukan perulangan

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Function ViewHolder -> Menginisialisasi variable yang akan digunakan di Adapter, ini ada hubungannya
        // dengan Item yang sudah dibuat

        // Inisialisasi data
        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val imgPoster: ImageView = view.findViewById(R.id.img_poster)

        // Menampilkan data
        fun bindItem(
            data: MovieModel,
            listener: (MovieModel) -> Unit,
            context: Context,
            position: Int
        ) {
            tvTitle.text = data.title

            Glide.with(context)
                .load(data.poster)
                .into(imgPoster)

            itemView.setOnClickListener {
                listener(data)
            }
        }
    }
}
package com.example.icetflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.icetflix.model.Movie

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = mutableListOf<Movie>()
        for ( i in 0 until 60){
            val movie = Movie(coverUrl = "https://exemplo.com/$i.jpg")
            movies.add(movie)
        }

        val adapter = MainAdapter(movies)
        val rv: RecyclerView = findViewById(R.id.rv_main)
        rv.layoutManager= LinearLayoutManager(this)
        rv.adapter = adapter
    }
}
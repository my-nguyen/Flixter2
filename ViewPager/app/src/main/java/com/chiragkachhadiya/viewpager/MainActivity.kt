package com.chiragkachhadiya.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.chiragkachhadiya.viewpager.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            setPageTransformer(makePageTransformer())
            adapter = MoviesAdapter(makeMovies())
        }
    }

    private fun makePageTransformer(): CompositePageTransformer {
        val pageTransformer = CompositePageTransformer()
        pageTransformer.addTransformer(MarginPageTransformer(10))
        pageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        return pageTransformer
    }

    private fun makeMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        movies.add(Movie("Passengers", "Science fiction", "December 22, 2016", R.drawable.passengers, 4.6f))
        movies.add(Movie("The Tomorrow War", "Science fiction", "December 14, 2016", R.drawable.the_tomorrow_war, 4.6f))
        movies.add(Movie("Annihilation", "Science fiction", "February 13, 2018", R.drawable.annihilation, 3.5f))
        movies.add(Movie("The Martian", "Science fiction", "October 2, 2015", R.drawable.the_martian, 5.0f))

        return movies
    }
}
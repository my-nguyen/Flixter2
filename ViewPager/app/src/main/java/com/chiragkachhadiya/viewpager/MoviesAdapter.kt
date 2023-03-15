package com.chiragkachhadiya.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chiragkachhadiya.viewpager.databinding.ItemMovieBinding

class MoviesAdapter(val movies: List<Movie>): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.apply {
                poster.setImageResource(movie.poster)
                name.text = movie.name
                category.text = movie.category
                release.text = movie.release
                rating.rating = movie.rating
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}
package com.chiragkachhadiya.slider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chiragkachhadiya.slider.databinding.ItemSlideBinding

class SlidesAdapter(val slides: List<Slide>): RecyclerView.Adapter<SlidesAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemSlideBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(slide: Slide) {
            binding.apply {
                title.text = slide.title
                description.text = slide.description
                icon.setImageResource(slide.icon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSlideBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = slides.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(slides[position])
    }
}
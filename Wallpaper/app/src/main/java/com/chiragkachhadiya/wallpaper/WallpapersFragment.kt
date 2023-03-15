package com.chiragkachhadiya.wallpaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chiragkachhadiya.wallpaper.databinding.FragmentWallpapersBinding

class WallpapersFragment : Fragment() {
    private var _binding: FragmentWallpapersBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View? {
        if (_binding == null) {
            _binding = FragmentWallpapersBinding.inflate(inflater, container, false)
            setListeners()
        }
        return binding.root
    }

    private fun setListeners() {
        binding.search.setOnClickListener {
            findNavController().navigate(WallpapersFragmentDirections.actionWallpapersToSearch())
        }
    }
}
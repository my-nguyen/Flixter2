package com.chiragkachhadiya.slider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.chiragkachhadiya.slider.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: SlidesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        adapter = SlidesAdapter(makeSlides())
        binding.viewPager.adapter = adapter
        setupIndicators()
        setCurrentIndicator(0)
        binding.viewPager.registerOnPageChangeCallback(object: OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        binding.next.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < adapter.itemCount) {
                binding.viewPager.currentItem++
            } else {
                toEmptyActitvity()
            }
        }

        binding.skipIntro.setOnClickListener {
            toEmptyActitvity()
        }
        
        return binding.root
    }

    private fun makeSlides(): List<Slide> {
        val slides = mutableListOf<Slide>()
        slides.add(
            Slide(
                "Sunlight",
                "Sunlight is the light and energy that comes from the Sun.",
                R.drawable.ic_sunlight
            )
        )
        slides.add(
            Slide(
                "Pay Online",
                "Electronic bill payment is a feature of online, mobile and telephone banking",
                R.drawable.ic_pay_online
            )
        )
        slides.add(
            Slide(
                "Video Streaming",
                "Streaming media is multimedia that is constantly received by and presented to an end user",
                R.drawable.ic_video_streaming
            )
        )
        return slides
    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val params = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        params.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(requireActivity()).apply {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        requireActivity(),
                        R.drawable.indicator_inactive
                    )
                )
                layoutParams = params
            }
            binding.indicators.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        for (i in 0 until binding.indicators.childCount) {
            val imageView = binding.indicators.getChildAt(i) as ImageView
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    requireActivity(),
                    if (i == index) R.drawable.indicator_active else R.drawable.indicator_inactive
                )
            )
        }
    }

    private fun toEmptyActitvity() {
        findNavController().navigate(R.id.emptyFragment)
    }
}
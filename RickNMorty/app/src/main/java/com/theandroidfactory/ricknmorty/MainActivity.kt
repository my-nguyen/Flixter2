package com.theandroidfactory.ricknmorty

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.theandroidfactory.ricknmorty.databinding.ActivityMainBinding

private const val TAG = "MainActivity-Truong"

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }
    private val epoxy = CharacterEpoxy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.character.observe(this) {
            epoxy.response = it
            if (it == null) {
                Toast.makeText(this@MainActivity, "Unsuccessful network call", Toast.LENGTH_LONG).show()
                return@observe
            }

//            binding.apply {
//                name.text = it.name
//                status.text = it.status
//                species.text = it.species
//                origin.text = it.origin.name
//                Picasso.get().load(it.image).into(image)
//                gender.setImageResource(
//                    if (it.gender.equals("male", true)) R.drawable.ic_male else R.drawable.ic_female
//                )
//            }
        }
        viewModel.refreshCharacter(54)
        binding.recycler.
    }
}
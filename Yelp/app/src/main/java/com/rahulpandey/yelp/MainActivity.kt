package com.rahulpandey.yelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahulpandey.yelp.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.yelp.com/v3/"
const val TAG = "Main-Truong"
const val API_KEY =
    "7WnY3zVPZ8Yj9S8JWphAu5dn8myhk0N0eAZ4P5vluMBcEg7t1gc41fdBHgluTHLNziDGBiH0UvciG4-p-IJQfPvR5Pdhd9WJ1G4pQnwZr6_cZG54KU6rZVrjITSfX3Yx"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurants = mutableListOf<Restaurant>()
        val adapter = RestaurantsAdapter(restaurants)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(YelpService::class.java)
        service.findRestaurants("Bearer $API_KEY", "In-n-out", "San Jose")
            .enqueue(object : Callback<Restaurants> {
                override fun onFailure(call: Call<Restaurants>, t: Throwable) {
                    Log.d(TAG, "onFailure $t")
                }

                override fun onResponse(call: Call<Restaurants>, response: Response<Restaurants>) {
                    Log.d(TAG, "onResponse $response")
                    val body = response.body()
                    if (body == null) {
                        Log.w(TAG, "Invalid response from Yelp API")
                    } else {
                        restaurants.addAll(body.businesses)
                        adapter.notifyDataSetChanged()
                    }
                }
            })
    }
}
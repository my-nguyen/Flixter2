package com.rahulpandey.yelp

data class Restaurants(val total: Int, val businesses: List<Restaurant>)

data class Restaurant(
    val name: String,
    val rating: Double,
    val price: String,
    val review_count: Int,
    val distance: Double,
    val image_url: String,
    val categories: List<Category>,
    val location: Location
) {
    fun toMiles(): String {
        val perMeter = 0.000621371
        val miles = "%.2f".format(distance * perMeter)
        return "$miles mi"
    }
}

data class Category(val title: String)

data class Location(val address1: String)
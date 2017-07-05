package com.codingblocks.restapiretrofitjson.models

/**
 * Created by championswimmer on 29/06/17.
 */
data class User(
        val id: Int,
        val username: String,
        val name: String,
        val email: String,
        val phone: String,
        val address: Address
) {
    data class Address (
            val street: String,
            val suite: String,
            val city: String,
            val zipcode: String,
            val geo: Geo
    ) {
        data class Geo(
                val lat: String,
                val lng: String
        )
    }
}
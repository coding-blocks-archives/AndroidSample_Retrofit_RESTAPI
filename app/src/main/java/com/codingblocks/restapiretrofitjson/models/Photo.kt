package com.codingblocks.restapiretrofitjson.models

/**
 * Created by abheisenberg on 2/7/17.
 */
data class Photo(
        val albumId : Int,
        val id: Int,
        val title: String,
        val url: String,
        val thumbnailUrl: String
)
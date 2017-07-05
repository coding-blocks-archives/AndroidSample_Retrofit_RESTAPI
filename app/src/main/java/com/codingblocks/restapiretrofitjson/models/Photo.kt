package com.codingblocks.restapiretrofitjson.models

/**
 * Created by User on 06-07-2017.
 */
data class Photo(
        val albumId: Int,
        val id: Int,
        val title: String,
        val url: String,
        val thumbnailUrl: String
)
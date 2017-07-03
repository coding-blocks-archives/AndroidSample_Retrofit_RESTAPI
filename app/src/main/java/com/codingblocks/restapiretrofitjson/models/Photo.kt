package com.codingblocks.restapiretrofitjson.models

/**
 * Created by Suraj on 6/30/2017.
 */

data class Photo(
        val albumId: kotlin.Int,
        val id: kotlin.Int,
        val title: String,
        val url: String,
        val thumbnailUrl: String
)
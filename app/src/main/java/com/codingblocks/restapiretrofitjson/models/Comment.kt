package com.codingblocks.restapiretrofitjson.models

/**
 * Created by Suraj on 6/29/2017.
 */

data class Comment (
        val postId: Int,
        val id: Int,
        val name: String,
        val email: String,
        val body: String
)
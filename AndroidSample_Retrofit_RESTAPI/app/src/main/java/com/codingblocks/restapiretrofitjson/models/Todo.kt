package com.codingblocks.restapiretrofitjson.models

/**
 * Created by championswimmer on 02/07/17.
 */
data class Todo (
        val id: Int, val userId: Int,
        val title: String, val completed: Boolean
)
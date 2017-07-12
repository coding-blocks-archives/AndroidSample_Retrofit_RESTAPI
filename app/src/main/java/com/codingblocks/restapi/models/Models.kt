package com.codingblocks.restapi.models

/**
 * Created by championswimmer on 12/07/17.
 */
data class Post(val userId: Int, val id: Int, val title: String, val body: String)

data class Todo(val id: Int, val userId: Int, val title: String, val isCompleted: Boolean)

data class Album(val id: Int, val userId: Int, val title: String)

data class User(val id: Int, val name: String, val username: String, val email: String, val phone: String)

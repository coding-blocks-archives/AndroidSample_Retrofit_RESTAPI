package com.codingblocks.restapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by championswimmer on 12/07/17.
 */

object Client {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val api = retrofit.create(JsonPlaceholderApi::class.java)

}

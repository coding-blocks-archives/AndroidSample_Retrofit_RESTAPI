package com.codingblocks.restapi.utils.kotlin

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by championswimmer on 12/07/17.
 */

fun <T> callback(fn: (Throwable?, Response<T>?) -> Unit): Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: retrofit2.Response<T>) = fn(null, response)
        override fun onFailure(call: Call<T>, t: Throwable) = fn(t, null)
    }
}
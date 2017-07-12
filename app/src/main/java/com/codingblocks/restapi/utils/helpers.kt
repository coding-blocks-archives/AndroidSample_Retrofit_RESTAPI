package com.codingblocks.restapi.utils

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by championswimmer on 12/07/17.
 */

fun <T> rfcb(fn: (Throwable?, Response<T>?) -> Unit) : Callback<T> {

    return object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) = fn(t, null)

        override fun onResponse(call: Call<T>?, response: Response<T>?) = fn(null, response)

    }
}
package com.techmashinani.filamu.utils


import android.content.Context
import android.widget.Toast
import okhttp3.HttpUrl
import okhttp3.Request
import timber.log.Timber

fun String.toast(context: Context, showLong: Boolean = true) {
    Toast.makeText(context, this, if(showLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

// change url
fun Request.addQuery(name: String, value: String?): Request {
    val url: okhttp3.HttpUrl = this.url()

    Timber.e("Initial Url $url")
    val builder = url
        .newBuilder()
        .addQuery(name, value)
        .build()

    Timber.e("Add Query Called >>> Final Url ${builder.url()}")

    return newBuilder()
        .url(builder)
        .build()
}


// adding query to the request
fun HttpUrl.Builder.addQuery(name: String, value: String?): HttpUrl.Builder {
    this.addQueryParameter(name, value)
    return this
}
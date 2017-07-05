package com.codingblocks.restapiretrofitjson.models

/**
 * Created by Harshi on 7/5/2017.
 */
class Thumbnail(title: String, thumbnailURL: String, url: String) {
    var title: String
        internal set
    var thumbnailUrl: String
        internal set
    var url: String
        internal set

    init {
        this.title = title
        this.thumbnailUrl = thumbnailURL
        this.url = url

    }
}
package com.example.xmlparsingrssfeedhttpurlconnections

import com.example.xmlparsingrssfeedhttpurlconnections.model.Rss
import retrofit2.Call
import retrofit2.http.GET

interface APIClient {
    @get:GET("/feed/")
    val rss: Call<Rss?>?
}
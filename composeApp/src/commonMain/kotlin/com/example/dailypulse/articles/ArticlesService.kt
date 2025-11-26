package com.example.dailypulse.articles

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(
    private val client: HttpClient
) {
    private val country = "br"
    private val category = "business"
    private val apiKey = "46c9b6e21ab94d8b880ee1b8323742e9"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = client
            .get("https://newsapi.org/v2/top-headlines?country${country}" +
                    "&category=${category}&apiKey=${apiKey}").body()
        return response.articles
    }
}
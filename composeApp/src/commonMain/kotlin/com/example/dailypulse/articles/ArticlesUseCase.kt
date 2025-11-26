package com.example.dailypulse.articles

class ArticlesUseCase(
    private val articlesService: ArticlesService
) {
    suspend fun getArticles(): List<Article> {
        val rawArticles = articlesService.fetchArticles()
        return rawArticles.map { it.toArticle() }
    }
}

private fun ArticleRaw.toArticle(): Article {
    return Article(
        title = title,
        desc = description ?: "Click out to find out more",
        date = date,
        imageUrl = imageUrl ?: ""
    )
}
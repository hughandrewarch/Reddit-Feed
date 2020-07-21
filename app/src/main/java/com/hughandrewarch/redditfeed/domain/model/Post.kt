package com.hughandrewarch.redditfeed.domain.model

data class Post(
    val subreddit: String,
    val title: String,
    val author: String,
    val thumbnail: String
)
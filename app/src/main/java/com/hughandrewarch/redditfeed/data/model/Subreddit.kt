package com.hughandrewarch.redditfeed.data.model

data class Subreddit(
    val modhash: String,
    val dist: Long,
    val children: List<Post>,
    val after: String? = null,
    val before: String? = null
)
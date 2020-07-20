package com.hughandrewarch.redditfeed.domain.model

data class Subreddit(
    val modhash: String,
    val dist: Long,
    val children: List<Post>,
    val after: String? = null,
    val before: String? = null
)
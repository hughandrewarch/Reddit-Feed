package com.hughandrewarch.redditfeed.network.models

import com.google.gson.annotations.SerializedName
import com.hughandrewarch.redditfeed.domain.model.Post

class PostResponse {
    @SerializedName("subreddit")
    lateinit var subreddit: String
    @SerializedName("title")
    lateinit var title: String
    @SerializedName("author")
    lateinit var author: String
    @SerializedName("thumbnail")
    lateinit var thumbnail: String
    @SerializedName("url")
    lateinit var url: String

    companion object {
        fun map(response: PostResponse): Post {
            return Post(
                subreddit = response.subreddit,
                title = response.title,
                author = response.author,
                thumbnail = response.thumbnail,
                url = response.url
            )
        }
    }
}
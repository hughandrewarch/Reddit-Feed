package com.hughandrewarch.redditfeed.network.models

import com.google.gson.annotations.SerializedName
import com.hughandrewarch.redditfeed.domain.model.Post

class PostResponse {
    @SerializedName("subreddit")
    lateinit var subreddit: String
    @SerializedName("author_fullname")
    lateinit var author: String
    @SerializedName("title")
    lateinit var title: String

    companion object {
        fun map(response: PostResponse): Post {
            return Post(
                title = response.title
            )
        }
    }
}
package com.hughandrewarch.redditfeed.network.models

import com.google.gson.annotations.SerializedName
import com.hughandrewarch.redditfeed.domain.model.Subreddit

class SubredditResponse {
    @SerializedName("modhash")
    lateinit var modhash: String

    @SerializedName("dist")
    var dist: Long = 0

    @SerializedName("children")
    lateinit var children: List<DataWrapper<PostResponse>>

    @SerializedName("after")
    var after: String? = null

    @SerializedName("before")
    var before: String? = null

    companion object {
        fun map(response: SubredditResponse): Subreddit {
            return Subreddit(
                modhash = response.modhash,
                dist = response.dist,
                children = response.children.map{ PostResponse.map(it.data) },
                after = response.after,
                before = response.before
            )
        }
    }
}
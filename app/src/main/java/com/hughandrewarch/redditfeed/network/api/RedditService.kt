package com.hughandrewarch.redditfeed.network.api

import com.hughandrewarch.redditfeed.network.models.DataWrapper
import com.hughandrewarch.redditfeed.network.models.SubredditResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditService {
//    @GET("/r/kotlin/.json")
//    fun getSubredditPost(): Observable<Result<Void>>

    @GET("/r/{subreddit}/.json")
    fun getSubredditPost(@Path("subreddit") subreddit: String): Observable<DataWrapper<SubredditResponse>>
}
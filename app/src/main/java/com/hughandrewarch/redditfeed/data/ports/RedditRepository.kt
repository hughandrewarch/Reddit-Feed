package com.hughandrewarch.redditfeed.data.ports

import com.hughandrewarch.redditfeed.data.model.Subreddit
import io.reactivex.rxjava3.core.Observable

interface RedditRepository {
    fun getSubreddit(subreddit: String): Observable<Subreddit>
}

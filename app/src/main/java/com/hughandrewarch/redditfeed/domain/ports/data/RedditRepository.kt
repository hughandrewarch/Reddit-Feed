package com.hughandrewarch.redditfeed.domain.ports.data

import com.hughandrewarch.redditfeed.domain.model.Subreddit
import io.reactivex.rxjava3.core.Observable

interface RedditRepository {
    fun getSubreddit(subreddit: String): Observable<Subreddit>
}

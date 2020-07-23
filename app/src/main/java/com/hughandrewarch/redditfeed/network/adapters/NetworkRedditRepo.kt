package com.hughandrewarch.redditfeed.network.adapters

import com.hughandrewarch.redditfeed.data.model.Subreddit
import com.hughandrewarch.redditfeed.data.ports.RedditRepository
import com.hughandrewarch.redditfeed.data.ports.RetrofitRepo
import com.hughandrewarch.redditfeed.network.api.RedditService
import com.hughandrewarch.redditfeed.network.models.SubredditResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class NetworkRedditRepo: RedditRepository, RetrofitRepo<RedditService>(RedditService::class.java) {

    override val baseUrl: String
        get() = "https://reddit.com"

    override fun getSubreddit(subreddit: String): Observable<Subreddit> {

        return service.getSubreddit(subreddit)
            .map{SubredditResponse.map(it.data)}
            .subscribeOn(Schedulers.io())//TODO move subscribeOn/observeOn
            .observeOn(AndroidSchedulers.mainThread())
    }
}
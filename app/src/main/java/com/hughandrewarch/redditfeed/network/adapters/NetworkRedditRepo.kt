package com.hughandrewarch.redditfeed.network.adapters

import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.domain.ports.data.RedditRepository
import com.hughandrewarch.redditfeed.network.api.RedditService
import com.hughandrewarch.redditfeed.network.models.SubredditResponse
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRedditRepo: RedditRepository {
    private val service: RedditService

    companion object {
        const val BASE_URL = "https://reddit.com"
    }

    init {
        //TODO extract this
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(RedditService::class.java)
    }

    override fun getSubreddit(subreddit: String): Observable<Subreddit> {
        val subredditPost = service.getSubredditPost("kotlin")
        return subredditPost
            .map{SubredditResponse.map(it.data)}
            .subscribeOn(Schedulers.io())//TODO move subscribeOn/observeOn
            .observeOn(AndroidSchedulers.mainThread())
    }
}
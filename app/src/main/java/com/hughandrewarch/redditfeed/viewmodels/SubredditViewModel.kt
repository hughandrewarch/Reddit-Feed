package com.hughandrewarch.redditfeed.viewmodels

import androidx.databinding.BaseObservable
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.network.adapters.NetworkRedditRepo
import io.reactivex.rxjava3.kotlin.subscribeBy

class SubredditViewModel: BaseObservable() {
    private lateinit var subreddit: Subreddit

    fun onLoginClicked()  {
        val network = NetworkRedditRepo()
        network.getSubreddit("kotlin")
            .subscribeBy(
                onNext =  {
                    subreddit = it
                },
                onError = { println(it) }
            )
    }

}
package com.hughandrewarch.redditfeed.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hughandrewarch.redditfeed.data.model.Subreddit
import com.hughandrewarch.redditfeed.network.adapters.NetworkRedditRepo
import io.reactivex.rxjava3.kotlin.subscribeBy

class SubredditViewModel: ViewModel() {
    val subreddit: MutableLiveData<Subreddit> by lazy {
        MutableLiveData<Subreddit>()
    }

    fun getSubreddit(subreddit: String)  {
        val network = NetworkRedditRepo()
        network.getSubreddit(subreddit)
            .subscribeBy(
                onNext =  {
                    this.subreddit.value = it
                },
                onError = { println(it) }
            )
    }
}
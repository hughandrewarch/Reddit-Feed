package com.hughandrewarch.redditfeed.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.network.adapters.NetworkRedditRepo
import io.reactivex.rxjava3.kotlin.subscribeBy

class SubredditViewModel: ViewModel() {
    val subreddit: MutableLiveData<Subreddit> by lazy {
        MutableLiveData<Subreddit>()
    }

    fun onTestClicked()  {
        val network = NetworkRedditRepo()
        network.getSubreddit("dndArt")
            .subscribeBy(
                onNext =  {
                    subreddit.value = it
                },
                onError = { println(it) }
            )
    }

}
package com.hughandrewarch.redditfeed.viewmodels

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.network.adapters.NetworkRedditRepo
import io.reactivex.rxjava3.kotlin.subscribeBy

class SubredditViewModel: ViewModel() {
//    private lateinit var subreddit: Subreddit

    val subreddit: MutableLiveData<Subreddit> by lazy {
        MutableLiveData<Subreddit>()
    }

    fun onLoginClicked()  {
        val network = NetworkRedditRepo()
        network.getSubreddit("kotlin")
            .subscribeBy(
                onNext =  {
                    subreddit.value = it
                },
                onError = { println(it) }
            )
    }

}
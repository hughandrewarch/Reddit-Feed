package com.hughandrewarch.redditfeed

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.hughandrewarch.redditfeed.databinding.ActivityMainBinding
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.viewmodels.SubredditViewModel
import com.hughandrewarch.redditfeed.views.fragments.PostListFragment

class MainActivity : AppCompatActivity() {

    private val subredditViewModel: SubredditViewModel by viewModels()
    private val postListFragment = PostListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame,
            postListFragment
        )
        fragmentTransaction.commit()

        subredditViewModel.subreddit.observe(this, subredditObserver)
        activityMainBinding.viewModel = subredditViewModel
        activityMainBinding.executePendingBindings()

        subredditViewModel.getSubreddit("kotlin")
    }

    private val subredditObserver = Observer<Subreddit> { subreddit ->
        postListFragment.setPosts(subreddit.children)
    }
}
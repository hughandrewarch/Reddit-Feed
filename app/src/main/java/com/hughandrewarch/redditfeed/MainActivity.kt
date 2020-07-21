package com.hughandrewarch.redditfeed

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hughandrewarch.redditfeed.databinding.ActivityMainBinding
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.view.adapter.PostViewAdapter
import com.hughandrewarch.redditfeed.viewmodels.SubredditViewModel


class MainActivity : AppCompatActivity() {

    private val subredditViewModel: SubredditViewModel by viewModels()
    private lateinit var postViewAdapter: PostViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subredditViewModel.subreddit.observe(this, subredditObserver)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.viewModel = subredditViewModel
        activityMainBinding.executePendingBindings()

        postViewAdapter = PostViewAdapter(this, arrayListOf())

        val postRecyclerView: RecyclerView = findViewById(R.id.post_list)
        postRecyclerView.layoutManager = LinearLayoutManager(this)
        postRecyclerView.adapter = postViewAdapter
    }

    private val subredditObserver = Observer<Subreddit> { subreddit ->
        // Update the UI, in this case, a TextView.
        postViewAdapter.update(subreddit.children)
    }
}
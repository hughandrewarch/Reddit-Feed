package com.hughandrewarch.redditfeed

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hughandrewarch.redditfeed.viewmodels.SubredditViewModel
import com.hughandrewarch.redditfeed.views.PostListFragment
import com.hughandrewarch.redditfeed.views.adapter.PostViewAdapter

class MainActivity : AppCompatActivity() {

    private val subredditViewModel: SubredditViewModel by viewModels()
    private lateinit var postViewAdapter: PostViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, PostListFragment())
        fragmentTransaction.commit()
    }
}
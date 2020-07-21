package com.hughandrewarch.redditfeed

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.hughandrewarch.redditfeed.databinding.ActivityMainBinding
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.viewmodels.SubredditViewModel

class MainActivity : AppCompatActivity() {

    private val subredditViewModel: SubredditViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subredditViewModel.subreddit.observe(this, subredditObserver)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.viewModel = subredditViewModel
        activityMainBinding.executePendingBindings()
    }

    val subredditObserver = Observer<Subreddit> { subreddit ->
        // Update the UI, in this case, a TextView.
        Toast.makeText(this, "HELLO", Toast.LENGTH_SHORT).show()
    }

}

package com.hughandrewarch.redditfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hughandrewarch.redditfeed.databinding.ActivityMainBinding
import com.hughandrewarch.redditfeed.viewmodels.SubredditViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding.viewModel = SubredditViewModel()
        activityMainBinding.executePendingBindings()
    }

}

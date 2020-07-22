package com.hughandrewarch.redditfeed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hughandrewarch.redditfeed.views.fragments.PostListFragment

class MainActivity : AppCompatActivity() {

    private val postListFragment = PostListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame,
            postListFragment
        )
        fragmentTransaction.commit()
    }
}
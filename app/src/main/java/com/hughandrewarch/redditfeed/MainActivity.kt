package com.hughandrewarch.redditfeed

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hughandrewarch.redditfeed.network.adapters.NetworkRedditRepo
import io.reactivex.rxjava3.kotlin.subscribeBy

class MainActivity : AppCompatActivity() {

    private lateinit var testButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testButton = findViewById(R.id.button)

        testButton.setOnClickListener{ onClick() }
    }

    fun onClick() {
        val network = NetworkRedditRepo()
        network.getSubreddit("")
            .subscribeBy(
                onNext =  { it ->
                    Toast.makeText(this, "YAS", Toast.LENGTH_LONG).show()
                },
                onError = { println(it) }
            )
    }
}

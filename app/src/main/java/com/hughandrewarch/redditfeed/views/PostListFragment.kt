package com.hughandrewarch.redditfeed.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hughandrewarch.redditfeed.R
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.viewmodels.SubredditViewModel
import com.hughandrewarch.redditfeed.views.adapter.PostViewAdapter
import kotlinx.android.synthetic.main.post_list_fragment.*

class PostListFragment: Fragment() {
    private val subredditViewModel: SubredditViewModel by activityViewModels()
    private lateinit var postViewAdapter: PostViewAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.post_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subredditViewModel.subreddit.observe(viewLifecycleOwner, subredditObserver)

        postViewAdapter = PostViewAdapter(arrayListOf())

        post_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = postViewAdapter
        }

        button.setOnClickListener{
            subredditViewModel.onTestClicked()
        }
    }

    private val subredditObserver = Observer<Subreddit> { subreddit ->
        postViewAdapter.update(subreddit.children)
    }
}
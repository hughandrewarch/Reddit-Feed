package com.hughandrewarch.redditfeed.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hughandrewarch.redditfeed.R
import com.hughandrewarch.redditfeed.databinding.PostListFragmentBinding
import com.hughandrewarch.redditfeed.domain.model.Post
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import com.hughandrewarch.redditfeed.viewmodels.SubredditViewModel
import com.hughandrewarch.redditfeed.views.adapter.PostViewAdapter
import kotlinx.android.synthetic.main.post_list_fragment.*

class PostListFragment : Fragment() {

    private val subredditViewModel: SubredditViewModel by activityViewModels()
    private lateinit var postViewAdapter: PostViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val postListFragmentBinding: PostListFragmentBinding =
            DataBindingUtil.inflate<PostListFragmentBinding>(
                inflater, R.layout.post_list_fragment, container, false
            )

        subredditViewModel.subreddit.observe(viewLifecycleOwner, subredditObserver)
        postListFragmentBinding.viewModel = subredditViewModel
        postListFragmentBinding.executePendingBindings()

        return postListFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postViewAdapter = PostViewAdapter(arrayListOf()) { post ->
            launchPostFragment(post)
        }

        post_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = postViewAdapter
        }

        subredditViewModel.getSubreddit("kotlin")
    }

    fun launchPostFragment(post: Post) {

        val fragmentTransaction = parentFragmentManager.beginTransaction()

        fragmentTransaction.replace(
            R.id.frame,
            PostFragment.newInstance(post)
        ).addToBackStack(null)

        fragmentTransaction.commit()
    }

    private val subredditObserver = Observer<Subreddit> { subreddit ->
        postViewAdapter.update(subreddit.children)
    }
}
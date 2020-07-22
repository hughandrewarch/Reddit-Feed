package com.hughandrewarch.redditfeed.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.hughandrewarch.redditfeed.R
import com.hughandrewarch.redditfeed.domain.model.Post
import com.hughandrewarch.redditfeed.views.adapter.PostViewAdapter
import kotlinx.android.synthetic.main.post_list_fragment.*

class PostListFragment : Fragment() {
    private lateinit var postViewAdapter: PostViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_list_fragment, container, false)
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
    }

    fun setPosts(posts: List<Post>) {
        postViewAdapter.update(posts)
    }

    fun launchPostFragment(post: Post) {

        val fragmentTransaction = parentFragmentManager.beginTransaction()

        fragmentTransaction.replace(
            R.id.frame,
            PostFragment.newInstance(post)
        )
        fragmentTransaction.commit()
    }

}
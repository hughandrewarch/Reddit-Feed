package com.hughandrewarch.redditfeed.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hughandrewarch.redditfeed.R
import com.hughandrewarch.redditfeed.data.model.Post
import kotlinx.android.synthetic.main.post_fragment.*

class PostFragment: Fragment() {
    private var post: Post? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.post_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        post = requireArguments().getParcelable<Post>("post") as Post
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
    }
    
    private fun setData() {
        val url = post?.url
        if (!url.isNullOrEmpty()) {
            webview.loadUrl(url)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(post: Post) = PostFragment().apply {
            arguments = Bundle().apply {
                putParcelable("post", post)
            }
        }
    }
}
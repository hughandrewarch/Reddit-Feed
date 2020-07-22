package com.hughandrewarch.redditfeed.views.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.hughandrewarch.redditfeed.R
import com.hughandrewarch.redditfeed.domain.model.Post
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
        title.text = post?.title
        author.text = post?.author

        Glide.with(thumbnail)
            .load(post?.thumbnail)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    thumbnail.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(thumbnail)
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
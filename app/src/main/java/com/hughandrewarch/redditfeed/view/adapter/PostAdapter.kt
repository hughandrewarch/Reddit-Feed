package com.hughandrewarch.redditfeed.view.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hughandrewarch.redditfeed.R
import com.hughandrewarch.redditfeed.domain.model.Post

class PostViewAdapter(
    var context: Activity,
    var posts: List<Post>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = posts[position]

        val viewHolder = holder as PostViewHolder
        viewHolder.title.text = post.title
        viewHolder.author.text = post.author
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun update(updated:List<Post>){
        posts = updated
        notifyDataSetChanged()
    }

    internal inner class PostViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)
        var author: TextView = itemView.findViewById(R.id.author)
    }
}
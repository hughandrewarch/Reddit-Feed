package com.hughandrewarch.redditfeed.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val subreddit: String,
    val title: String,
    val author: String,
    val thumbnail: String,
    val url: String
) : Parcelable
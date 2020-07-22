package com.hughandrewarch.redditfeed.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val subreddit: String,
    val title: String,
    val author: String,
    val thumbnail: String
) : Parcelable
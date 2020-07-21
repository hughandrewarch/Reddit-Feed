package com.hughandrewarch.redditfeed.network.models

data class DataWrapper<T>(val kind: String, val data: T)
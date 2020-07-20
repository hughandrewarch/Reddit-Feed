package com.hughandrewarch.redditfeed.network.models

class DataWrapper<T>(kind: String, data: T) {
    var kind = kind
    var data = data
}
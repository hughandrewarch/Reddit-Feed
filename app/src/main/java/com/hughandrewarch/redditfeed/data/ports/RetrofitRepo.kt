package com.hughandrewarch.redditfeed.data.ports

import com.hughandrewarch.redditfeed.network.RetrofitClient

abstract class RetrofitRepo<T>(test: Class<T>) {
    val service: T
    abstract val baseUrl: String

    init {
        val retrofit = RetrofitClient.instance
            .baseUrl(baseUrl())
            .build()

        service = retrofit.create(test)
    }

    private fun baseUrl(): String {
        return baseUrl
    }

    private inline fun <reified T> getGenericClass(): T {
        return T::class.java.newInstance()
    }
}
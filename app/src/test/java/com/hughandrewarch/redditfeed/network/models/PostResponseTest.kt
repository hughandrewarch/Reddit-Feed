package com.hughandrewarch.redditfeed.network.models

import com.hughandrewarch.redditfeed.domain.model.Post
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PostResponseTest {

    lateinit var subject: PostResponse

    @BeforeEach
    fun setUp() {
        subject = PostResponse()
        subject.subreddit = "subreddit"
        subject.author = "author"
        subject.title = "title"
    }

    @Test
    fun `map should map response to domain object`() {
        val result = PostResponse.map(subject)

        assertEquals(
            result,
            Post(
                subreddit = "subreddit",
                title = "title",
                author = "author"
            )
        )
    }
}
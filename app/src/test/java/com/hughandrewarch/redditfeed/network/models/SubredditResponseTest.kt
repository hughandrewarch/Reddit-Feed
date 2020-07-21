package com.hughandrewarch.redditfeed.network.models

import com.hughandrewarch.redditfeed.domain.model.Post
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SubredditResponseTest {

    lateinit var subject: SubredditResponse

    @BeforeEach
    fun setUp() {
        subject = SubredditResponse()

        subject.modhash = "modhash"
        subject.dist = 2
        subject.children = emptyList()
        subject.after = "after"
        subject.before = "before"
    }

    @Test
    fun `map should map response to domain object with empty list`() {
        val result = SubredditResponse.map(subject)

        assertEquals(
            result,
            Subreddit(
                modhash = "modhash",
                dist = 2,
                children = emptyList(),
                after = "after",
                before = "before"
            )
        )
    }

    @Test
    fun `map should map response to domain object with list of children`() {

        subject.children = listOf(
            wrappedPostResponse("author-1", "title-1", "subreddit-1"),
            wrappedPostResponse("author-2", "title-2", "subreddit-2")
        )

        val result = SubredditResponse.map(subject)

        assertEquals(
            result,
            Subreddit(
                modhash = "modhash",
                dist = 2,
                children = listOf(
                    Post("subreddit-1", "title-1","author-1"),
                    Post("subreddit-2", "title-2","author-2")
                ),
                after = "after",
                before = "before"
            )
        )
    }

    fun wrappedPostResponse(author: String, title: String, subreddit: String): DataWrapper<PostResponse> {
        val postResponse = PostResponse()
        postResponse.subreddit = subreddit
        postResponse.author = author
        postResponse.title = title

        return DataWrapper("", postResponse)
    }
}
package com.hughandrewarch.redditfeed.network.models

import com.hughandrewarch.redditfeed.domain.model.Post
import com.hughandrewarch.redditfeed.domain.model.Subreddit
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SubredditResponseTest {

    lateinit var subject: SubredditResponse

    lateinit var post1: PostResponse
    lateinit var post2: PostResponse

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
            wrappedPostResponse("subreddit-1","author-1","title-1"),
            wrappedPostResponse("subreddit-2","author-2","title-2")
        )

        val result = SubredditResponse.map(subject)

        assertEquals(
            result,
            Subreddit(
                modhash = "modhash",
                dist = 2,
                children = listOf(
                    Post("title-1"),
                    Post("title-2")
                ),
                after = "after",
                before = "before"
            )
        )
    }

    fun wrappedPostResponse(subreddit: String, author: String, title: String): DataWrapper<PostResponse> {
        val postResponse = PostResponse()
        postResponse.subreddit = subreddit
        postResponse.author = author
        postResponse.title = title

        return DataWrapper("", postResponse)
    }
}
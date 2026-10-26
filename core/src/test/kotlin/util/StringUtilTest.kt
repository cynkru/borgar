package com.shakster.borgar.core.util

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StringUtilTest {

    @Test
    fun splitChunksPreservesTextAndRespectsLimit() {
        val text = "first line\nsecond line with a long word"

        val chunks = text.splitChunks(10)

        assertEquals(text, chunks.joinToString(""))
        assertTrue(chunks.all { it.length <= 10 })
    }

    @Test
    fun splitChunksPrefersNewlineBoundaries() {
        val text = "first line\nsecond"

        assertEquals(listOf("first line\n", "second"), text.splitChunks(12))
    }
}

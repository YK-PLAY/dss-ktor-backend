package com.github.ykplay.dss.auth.user.exception

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 17:32
 */
internal class NotFoundUserExceptionTest {

    @Test
    fun getMessage() {
        val userId = "test"
        val exception = NotFoundUserException(userId)
        assertEquals("NotFoundUserException: $userId", exception.message)
    }
}
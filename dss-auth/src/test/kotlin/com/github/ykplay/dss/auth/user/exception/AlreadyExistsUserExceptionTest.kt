package com.github.ykplay.dss.auth.user.exception

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 17:29
 */
internal class AlreadyExistsUserExceptionTest {

    @Test
    fun getMessage() {
        val userId = "test"
        val exception = AlreadyExistsUserException(userId)
        assertEquals("AlreadyExistsUserException: $userId", exception.message)
    }
}
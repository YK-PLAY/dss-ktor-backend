package com.github.ykplay.dss.auth.user

import com.github.ykplay.dss.auth.user.exception.AlreadyExistsUserException
import com.github.ykplay.dss.auth.user.exception.NotFoundUserException
import com.github.ykplay.dss.common.cryto.Hash
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 17:08
 */
internal class UserMemoryServiceTest {

    @Test
    fun createUser() {
        val userService = UserMemoryService()
        val user = userService.createUser("hi", "test")

        assertEquals("hi", user.getUserId())

        val hash = Hash.hashSha256("test")
        assertEquals(hash, user.getPassword())
    }

    @Test
    fun createUserAlreadyExist() {
        val userService = UserMemoryService()
        userService.createUser("hi", "test")

        assertThrows(AlreadyExistsUserException::class.java) {
            userService.createUser("hi", "test2")
        }
    }

    @Test
    fun findUser() {
        val userService = UserMemoryService()
        userService.createUser("hi", "test")

        val user = userService.findUser("hi", "test")
        assertEquals("hi", user.getUserId())

        val hash = Hash.hashSha256("test")
        assertEquals(hash, user.getPassword())
    }

    @Test
    fun findUserNotExist() {
        val userService = UserMemoryService()

        assertThrows(NotFoundUserException::class.java) {
            userService.findUser("test", "hi")
        }
    }

    @Test
    fun findUserPasswordNotMatched() {
        val userService = UserMemoryService()
        userService.createUser("hi", "test")

        assertThrows(NotFoundUserException::class.java) {
            userService.findUser("hi", "test2")
        }
    }
}
package com.github.ykplay.dss.auth.service

import com.github.ykplay.dss.auth.provider.JwtCredentialProvider
import com.github.ykplay.dss.auth.user.UserMemoryService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.util.logging.Logger

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 22:25
 */
internal class DefaultAuthenticateUserIdPasswordServiceTest {

    private val logger = Logger.getLogger("DefaultAuthenticateUserIdPasswordServiceTest")

    @Test
    fun authorize() {
        val jwtCredentialProvider = JwtCredentialProvider()
        val userMemoryService = UserMemoryService()

        val authService = DefaultAuthenticateUserIdPasswordService(jwtCredentialProvider, userMemoryService)

        // create new user for test
        val userId = "user1"
        val password = "qwe!@#"
        userMemoryService.createUser(userId, password)

        // issue jwt token
        val token = authService.authorize(userId, password)
        logger.info("Issue token: $token")

        // validate token
        val claims = jwtCredentialProvider.getClaim(token)
        assertNotNull(claims)
        assertEquals(userId, claims["userKey"].toString())
    }
}
package com.github.ykplay.dss.auth.service

import com.github.ykplay.dss.auth.provider.JwtCredentialProvider
import com.github.ykplay.dss.auth.user.UserMemoryService

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 22:19
 */
class DefaultAuthenticateUserIdPasswordService(
    private val credentialProvider: JwtCredentialProvider,
    private val userService: UserMemoryService
): AuthenticateUserIdPasswordService() {

    override fun authorize(userId: String, password: String): String {
        val user = userService.findUser(userId, password)
        return credentialProvider.createToken(user.getUserId())
    }
}
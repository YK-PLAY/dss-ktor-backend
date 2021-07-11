package com.github.ykplay.dss.auth.user.model

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 16:18
 */
data class DefaultUser(
    private val userId: String,
    private val password: String
) : User {

    override fun getUserId(): String {
        return userId
    }

    override fun getPassword(): String {
        return password
    }
}

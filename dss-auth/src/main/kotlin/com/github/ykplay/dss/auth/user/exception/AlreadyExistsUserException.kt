package com.github.ykplay.dss.auth.user.exception

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 16:23
 */
open class AlreadyExistsUserException(
    private val userId : String
) : RuntimeException() {

    override val message: String?
        get() = "AlreadyExistsUserException: $userId"
}
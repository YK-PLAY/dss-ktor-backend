package com.github.ykplay.dss.auth.user

import com.github.ykplay.dss.auth.user.model.User

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 16:06
 */
interface UserService<out T> where T : User {

    fun findUser(userId: String, password: String) : T

    fun createUser(userId: String, password: String) : T
}
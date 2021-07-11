package com.github.ykplay.dss.auth.user.model

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 16:06
 */
interface User {

    fun getUserId() : String

    fun getPassword() : String
}
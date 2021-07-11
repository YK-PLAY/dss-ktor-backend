package com.github.ykplay.dss.auth.service

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 22:09
 */
abstract class AuthenticateUserIdPasswordService {
    abstract fun authorize(userId : String, password : String) : String
}
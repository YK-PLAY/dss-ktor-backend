package com.github.ykplay.dss.auth.provider

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 17:39
 */
interface CredentialProvider {

    fun createToken(userUniqueKey : String) : String
}
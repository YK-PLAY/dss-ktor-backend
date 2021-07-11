package com.github.ykplay.dss.common.cryto

import java.security.MessageDigest

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 16:45
 */
class Hash {
    companion object {
        fun hashSha256(value: String) : String {
            val bytes = value.toByteArray()
            val md = MessageDigest.getInstance("SHA-256")
            val digest = md.digest(bytes)
            return digest.fold("") { str, it -> str + "%02x".format(it) }
        }
    }
}
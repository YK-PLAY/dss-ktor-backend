package com.github.ykplay.dss.auth.user

import com.github.ykplay.dss.auth.user.exception.AlreadyExistsUserException
import com.github.ykplay.dss.auth.user.exception.NotFoundUserException
import com.github.ykplay.dss.auth.user.model.DefaultUser
import com.github.ykplay.dss.common.cryto.Hash

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 16:17
 */
class UserMemoryService : UserService<DefaultUser> {

    private val userMap = HashMap<String, DefaultUser>()

    override fun findUser(userId: String, password: String): DefaultUser {
        if (!userMap.containsKey(userId)) {
            throw NotFoundUserException(userId)
        }

        val user = userMap[userId]!!

        val hash = Hash.hashSha256(password)
        if (hash != user.getPassword()) {
            throw NotFoundUserException(userId)
        }

        return user
    }

    override fun createUser(userId: String, password: String): DefaultUser {
        val hash = Hash.hashSha256(password)
        val user = DefaultUser(userId, hash)
        userMap.putIfAbsent(userId, user) ?: return user

        throw AlreadyExistsUserException(userId)
    }
}
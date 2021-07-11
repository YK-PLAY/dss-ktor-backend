package com.github.ykplay.dss.auth.provider

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Encoders
import io.jsonwebtoken.security.Keys
import java.time.ZonedDateTime
import java.util.*

/**
 * @author Kebron ztkmkoo@gmail.com
 * @create 2021-07-11 17:46
 */
class JwtCredentialProvider : CredentialProvider {
    private val keyString = "i(kebron)loveyousomuchpuresin"
    private val key = Keys.hmacShaKeyFor(Encoders.BASE64.encode(keyString.toByteArray()).toByteArray())

    override fun createToken(userUniqueKey: String): String {
        val now = ZonedDateTime.now()
        val issuedAt = Date.from(now.toInstant())
        val expiredAt = Date.from(now.plusDays(30).toInstant())
        return Jwts
            .builder()
            .setHeaderParam("typ", "JWT")
            .claim("userKey", userUniqueKey)
            .setIssuedAt(issuedAt)
            .setExpiration(expiredAt)
            .signWith(key)
            .compact()
    }

    fun getClaim(token: String) : Claims {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).body
    }
}
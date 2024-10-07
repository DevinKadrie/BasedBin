package com.github.devinkadrie.basedbin

import java.security.SecureRandom
import java.security.spec.KeySpec
import java.util.HexFormat
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

private const val ALGORITHM = "PBKDF2WithHmacSHA512"
private const val ITERATIONS = 120_000
private const val KEY_LENGTH = 256
// set this to something real set in env
private const val SECRET = "SomeRandomSecret"

fun generateHash(password: String, salt: String): String {
    val combinedSalt = "$salt$SECRET".toByteArray()

    val factory: SecretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM)
    val spec: KeySpec = PBEKeySpec(password.toCharArray(), combinedSalt, ITERATIONS, KEY_LENGTH)
    val key: SecretKey = factory.generateSecret(spec)
    val hash: ByteArray = key.encoded

    return hash.toHexString()
}

fun generateRandomSalt(): ByteArray {
    val random = SecureRandom()
    val salt = ByteArray(16)
    random.nextBytes(salt)

    return salt
}

fun ByteArray.toHexString(): String = HexFormat.of().formatHex(this)

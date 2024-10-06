package com.github.devinkadrie.basedbin

import com.github.devinkadrie.basedbin.plugins.generateHash
import com.github.devinkadrie.basedbin.plugins.generateRandomSalt
import com.github.devinkadrie.basedbin.plugins.toHexString
import java.sql.Connection
import kotlinx.serialization.Serializable
import kotlinx.coroutines.*

@Serializable
data class User(val username : String, val password : String)

class UserNotFoundException(message: String = "User not found"): Exception(message)

class UserService(private val connection: Connection) {
    companion object {
        private const val CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS users (userName varchar(20) PRIMARY KEY, password Varchar(255), salt Varchar(255))"
        private const val SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE userName = ?"
        private const val INSERT_USER = "INSERT INTO users (userName, password, salt) VALUES (?, ?, ?)"
    }

    init {
        val statement = connection.createStatement()
        statement.executeUpdate(CREATE_TABLE_USERS)
    }

    suspend fun create(user: User) = withContext(Dispatchers.IO) {
        val statement = connection.prepareStatement(INSERT_USER)
        val salt = generateRandomSalt()
        println(generateHash(user.password, salt.toHexString()))
        statement.setString(1, user.username)
        statement.setString(2, generateHash(user.password, salt.toHexString()))
        statement.setString(3, salt.toHexString())
        statement.executeUpdate()
    }   

    suspend fun read(user: User) = withContext(Dispatchers.IO) {
        val statement = connection.prepareStatement(SELECT_USER_BY_USERNAME)
        statement.setString(1, user.username)
        val resultSet = statement.executeQuery()
        if (!(resultSet.next() && generateHash(user.password, resultSet.getString(3)) == resultSet.getString(2))) {
            throw UserNotFoundException()
        }
    }
}
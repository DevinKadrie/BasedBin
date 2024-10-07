package com.github.devinkadrie.basedbin

import java.sql.Connection
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable

@Serializable data class User(val username: String, val password: String)

class UserNotFoundException(message: String = "User not found") : Exception(message)

class DefaultUserService(private val connection: Connection) : UserService {
    companion object {
        private const val CREATE_TABLE_USERS =
            "CREATE TABLE IF NOT EXISTS users (userName varchar(20) PRIMARY KEY, password Varchar(255), salt Varchar(255))"
        private const val SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE userName = ?"
        private const val INSERT_USER =
            "INSERT INTO users (userName, password, salt) VALUES (?, ?, ?)"
    }

    init {
        val statement = connection.createStatement()
        statement.executeUpdate(CREATE_TABLE_USERS)
    }

    override suspend fun create(user: User) =
        withContext(Dispatchers.IO) {
            val statement = connection.prepareStatement(INSERT_USER)
            val salt = generateRandomSalt()
            statement.setString(1, user.username)
            statement.setString(2, generateHash(user.password, salt.toHexString()))
            statement.setString(3, salt.toHexString())
            statement.executeUpdate()
            Unit
        }

    override suspend fun exists(user: User) =
        withContext(Dispatchers.IO) {
            val statement = connection.prepareStatement(SELECT_USER_BY_USERNAME)
            statement.setString(1, user.username)
            val resultSet = statement.executeQuery()
            resultSet.next() &&
                generateHash(user.password, resultSet.getString(3)) == resultSet.getString(2)
        }
}

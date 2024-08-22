package com.github.devinkadrie.basedbin

import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import java.sql.Connection
import java.sql.Statement

@Serializable
data class Paste(val content: String)

class PasteService(private val connection: Connection) {
    companion object {
        private const val CREATE_TABLE_PASTES = "CREATE TABLE IF NOT EXISTS pastes (id SERIAL PRIMARY KEY, content VARCHAR(255));"
        private const val SELECT_PASTE_BY_ID = "SELECT content FROM pastes WHERE id = ?"
        private const val INSERT_PASTE = "INSERT INTO pastes (content) VALUES (?)"
    }

    init {
        val statement = connection.createStatement()
        statement.executeUpdate(CREATE_TABLE_PASTES)
    }

    suspend fun create(paste: Paste): Int = withContext(Dispatchers.IO) {
        val statement = connection.prepareStatement(INSERT_PASTE, Statement.RETURN_GENERATED_KEYS)
        statement.setString(1, paste.content)
        statement.executeUpdate()

        val generatedKeys = statement.generatedKeys
        if (generatedKeys.next()) {
            return@withContext generatedKeys.getInt(1)
        } else {
            throw Exception("Unable to retrieve the id of the newly inserted paste")
        }
    }

    suspend fun read(id: Int): Paste = withContext(Dispatchers.IO) {
        val statement = connection.prepareStatement(SELECT_PASTE_BY_ID)
        statement.setInt(1, id)
        val resultSet = statement.executeQuery()

        if (resultSet.next()) {
            val content = resultSet.getString("content")
            return@withContext Paste(content)
        } else {
            throw Exception("Record not found")
        }
    }
}


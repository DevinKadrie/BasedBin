package com.github.devinkadrie.basedbin

import com.fasterxml.uuid.Generators
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import java.sql.Connection
import java.sql.Statement
import java.util.UUID

@Serializable
data class Paste(val content: String)

class PasteService(private val connection: Connection) {
    companion object {
        private const val CREATE_TABLE_PASTES = "CREATE TABLE IF NOT EXISTS pastes (id UUID PRIMARY KEY, content VARCHAR(255));"
        private const val SELECT_PASTE_BY_ID = "SELECT content FROM pastes WHERE id = ?"
        private const val INSERT_PASTE = "INSERT INTO pastes (id, content) VALUES (?, ?)"
    }

    init {
        val statement = connection.createStatement()
        statement.executeUpdate(CREATE_TABLE_PASTES)
    }

    suspend fun create(paste: Paste): UUID = withContext(Dispatchers.IO) {
        val statement = connection.prepareStatement(INSERT_PASTE, Statement.RETURN_GENERATED_KEYS)

        val uuid = Generators.timeBasedEpochGenerator().generate()

        statement.setObject(1, uuid)
        statement.setString(2, paste.content)
        statement.executeUpdate()

        return@withContext uuid
    }

    suspend fun read(id: UUID): Paste = withContext(Dispatchers.IO) {
        val statement = connection.prepareStatement(SELECT_PASTE_BY_ID)
        statement.setObject(1, id)
        val resultSet = statement.executeQuery()

        if (resultSet.next()) {
            val content = resultSet.getString("content")
            return@withContext Paste(content)
        } else {
            throw Exception("Record not found")
        }
    }
}


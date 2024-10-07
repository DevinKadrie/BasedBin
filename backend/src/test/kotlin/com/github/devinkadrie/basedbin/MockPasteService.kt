package com.github.devinkadrie.basedbin

import java.util.*

class MockPasteService : PasteService {
    private val pastes: MutableMap<UUID, Paste> = mutableMapOf()

    override suspend fun create(paste: Paste): UUID? {
        val id = UUID.randomUUID()
        pastes[id] = paste
        return id
    }

    override suspend fun read(id: UUID): Paste? {
        return pastes[id]
    }
}

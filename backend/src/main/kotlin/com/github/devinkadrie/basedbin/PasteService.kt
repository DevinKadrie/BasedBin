package com.github.devinkadrie.basedbin

import java.util.*

interface PasteService {
    suspend fun create(paste: Paste): UUID?

    suspend fun read(id: UUID): Paste?
}

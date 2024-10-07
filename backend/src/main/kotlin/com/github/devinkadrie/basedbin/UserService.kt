package com.github.devinkadrie.basedbin

interface UserService {
    suspend fun create(user: User)

    suspend fun exists(user: User): Boolean
}

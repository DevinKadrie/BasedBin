package com.github.devinkadrie.basedbin

class MockUserService : UserService {
    private val users: MutableSet<User> = mutableSetOf()

    override suspend fun create(user: User) {
        users.add(user)
    }

    override suspend fun exists(user: User): Boolean = users.contains(user)
}

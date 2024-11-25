package com.github.devinkadrie.basedbin

/**
 * An interface to the set of registered users.
 *
 * @see [register]
 * @see [exists]
 */
interface UserService {
    /**
     * Add a new user.
     *
     * The user can be verified to exist later by calling [exists].
     *
     * @param[user] the user to add
     */
    suspend fun register(user: User)

    suspend fun exists(user: User): Boolean
}

package com.github.devinkadrie.basedbin

import kotlinx.serialization.Serializable

@Serializable data class User(val username: String, val password: String)

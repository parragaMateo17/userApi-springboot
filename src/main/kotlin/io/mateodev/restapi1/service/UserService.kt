package io.mateodev.restapi1.service

import io.mateodev.restapi1.data.User
import java.util.Optional

interface UserService {

    fun createUser(user: User): User

    fun findById(id: String): Optional<User>

    fun deleteUser(id: String): Unit

    fun all(): Iterable<User>
}
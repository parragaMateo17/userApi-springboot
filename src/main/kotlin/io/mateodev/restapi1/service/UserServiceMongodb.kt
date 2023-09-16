package io.mateodev.restapi1.service

import io.mateodev.restapi1.data.User
import io.mateodev.restapi1.data.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceMongodb(@Autowired private val userDao: UserDao):UserService {
    override fun createUser(user: User): User {
       return userDao.save(user)
    }

    override fun findById(id: String): Optional<User> {
        return userDao.findById(id)
    }

    override fun deleteUser(id: String): Unit{
        return userDao.deleteById(id)
    }

    override fun all(): Iterable<User> {
        return userDao.findAll()
    }
}


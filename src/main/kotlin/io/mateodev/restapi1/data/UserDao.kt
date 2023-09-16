package io.mateodev.restapi1.data

import org.springframework.data.mongodb.repository.MongoRepository

interface UserDao:MongoRepository<User, String> {
}
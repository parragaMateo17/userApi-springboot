package io.mateodev.restapi1.data


import io.mateodev.restapi1.controller.dto.UserDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date


@Document(value = "users")
data class User(
    @Id var id: String?,
    var name: String,
    var email: String,
    var created: Date
){
    constructor():this(null, "", "", Date())
    constructor(userDto: UserDto) : this(null, userDto.name, userDto.email, Date())
}

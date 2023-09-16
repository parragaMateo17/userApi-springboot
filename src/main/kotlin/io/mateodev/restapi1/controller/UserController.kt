package io.mateodev.restapi1.controller

import io.mateodev.restapi1.controller.dto.UserDto
import io.mateodev.restapi1.data.User
import io.mateodev.restapi1.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/user")
class UserController(@Autowired private val userService: UserService) {

    @PostMapping("/post")
    fun createUser(@RequestBody userDto: UserDto):ResponseEntity<User>{
       return ResponseEntity.ok(userService.createUser(User(userDto)))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:String): ResponseEntity<User>{
       val userOptional =  userService.findById(id)
        if(userOptional.isPresent){
            return ResponseEntity.ok(userOptional.get())
        }else{
            throw ResponseStatusException(HttpStatus.NOT_FOUND,
                "User with id $id not found")
        }
    }
    @GetMapping("/items")
    fun all(): ResponseEntity<Iterable<User>>{
        return  ResponseEntity.ok(userService.all())
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<String>{
        val user=  userService.findById(id)
        if(user.isPresent){
            userService.deleteUser(id)
            return  ResponseEntity.ok("Usuario con id $id eliminado")
        }else{
            return ResponseEntity.ok("El usuario no existe")
        }


    }
}
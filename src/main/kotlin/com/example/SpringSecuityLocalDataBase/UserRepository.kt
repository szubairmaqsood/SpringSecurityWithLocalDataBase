package com.example.SpringSecuityLocalDataBase

import org.springframework.data.jpa.repository.JpaRepository
import com.example.SpringSecuityLocalDataBase.models.User
import java.util.*

public interface UserRepository:JpaRepository<User,Int> {

    fun findByUserName(userName:String):Optional<User>
}
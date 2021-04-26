package com.example.SpringSecuityLocalDataBase


import com.example.SpringSecuityLocalDataBase.models.MyUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import com.example.SpringSecuityLocalDataBase.models.User
import java.util.*

@Service
class MyUserDetailsService:UserDetailsService {
    @Autowired
    var userRepositroy:UserRepository
    constructor(_userRepositroy:UserRepository){
        this.userRepositroy =_userRepositroy
    }
    override fun loadUserByUsername(username: String): UserDetails {
       var  user:Optional<User> =  this.userRepositroy.findByUserName(username)
        //return  MyUserDetails(user)
        return user.map(::MyUserDetails).get()


    }
}
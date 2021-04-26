package com.example.SpringSecuityLocalDataBase.models

import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

class MyUserDetails:UserDetails {
    private var userName:String
    private var password:String
    private var active:Boolean
    private var authorities:List<GrantedAuthority>




    constructor(user:User){
        this.userName = user.userName
        this.password = user.password
        this.active   = user.active
        this.authorities = user.roles
                //.map(::SimpleGrantedAuthority).collect(Collectors.toList())
    }
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return Arrays.asList(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getPassword(): String {
        return  this.getPassword()
    }

    override fun getUsername(): String? {
       return this.userName
    }

    override fun isAccountNonExpired(): Boolean {
      return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
      return this.isEnabled
    }
}
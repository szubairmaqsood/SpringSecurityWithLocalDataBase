package com.example.SpringSecuityLocalDataBase.models

import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class MyUserDetails:UserDetails {
    var userName:String?
    constructor(userName:String?){
        this.userName = userName
    }
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return Arrays.asList(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getPassword(): String {
        return  "pass"
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
      return true
    }
}
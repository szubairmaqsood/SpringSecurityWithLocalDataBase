package com.example.SpringSecuityLocalDataBase

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfigurations(@Autowired var userDetailService: UserDetailsService):WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(this.userDetailService)
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
                ?.antMatchers("/admin")?.hasRole("ADMIN")
                ?.antMatchers("/user")?.hasAnyRole("ADMIN","USER")
                ?.antMatchers("/")?.permitAll()
                ?.and()?.formLogin()
        }

    @Bean
    fun getPasswordEncoder():PasswordEncoder{
        return NoOpPasswordEncoder.getInstance()
    }
}
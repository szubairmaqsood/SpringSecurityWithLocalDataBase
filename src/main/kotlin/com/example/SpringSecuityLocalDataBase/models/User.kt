package com.example.SpringSecuityLocalDataBase.models

import javax.persistence.*

@Entity
@Table(name = "User")
public  class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int = 1
    var userName:String = ""
    var password:String = ""
    var active:Boolean = true
    var roles:String = ""

}
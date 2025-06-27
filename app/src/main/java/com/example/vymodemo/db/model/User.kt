package com.example.vymodemo.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/*
- First Name (fName)
- Last Name (lName)
- Email (email)
- Phone (phone)
- City (city)
 */

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val firstName: String? = null,
    val lastName:String? = null,
    val email:String? = null,
    val phone:Long? = null,
    val city:String? = null
)
package com.example.vymodemo.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.example.vymodemo.db.model.User


@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun addUser(user: User)

}
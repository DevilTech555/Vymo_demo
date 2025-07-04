package com.example.vymodemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vymodemo.db.dao.UserDao
import com.example.vymodemo.db.model.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao
}
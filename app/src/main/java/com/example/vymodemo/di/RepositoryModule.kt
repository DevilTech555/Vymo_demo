package com.example.vymodemo.di

import com.example.vymodemo.db.model.User

interface RepositoryModule {

    suspend fun insertUser(user: User)
}
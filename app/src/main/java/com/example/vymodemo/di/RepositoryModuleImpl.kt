package com.example.vymodemo.di

import com.example.vymodemo.db.AppDatabase
import com.example.vymodemo.db.model.User
import javax.inject.Inject


class RepositoryModuleImpl @Inject constructor(
    private val appDatabase: AppDatabase
): RepositoryModule {

    override suspend fun insertUser(user: User) {
        appDatabase.userDao().addUser(user)
    }
}
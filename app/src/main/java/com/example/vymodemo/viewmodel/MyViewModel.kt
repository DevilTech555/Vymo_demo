package com.example.vymodemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vymodemo.db.model.User
import com.example.vymodemo.di.RepositoryModule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repositoryModule: RepositoryModule
): ViewModel() {

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryModule.insertUser(user)
        }
    }
}
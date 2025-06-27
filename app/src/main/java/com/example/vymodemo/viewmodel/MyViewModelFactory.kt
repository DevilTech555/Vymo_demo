package com.example.vymodemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vymodemo.di.RepositoryModule


class MyViewModelFactory(
   private val repositoryModule: RepositoryModule
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(repositoryModule = repositoryModule) as T
    }
}
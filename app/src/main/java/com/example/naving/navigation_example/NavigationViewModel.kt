package com.example.naving.navigation_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigationViewModel : ViewModel() {

    private val _navigateTo = MutableLiveData<String?>()
    val navigateTo: LiveData<String?> get() = _navigateTo

    fun requestNavigation(destination: String) {
        _navigateTo.value = destination
    }

    fun onNavigationHandled() {
        _navigateTo.value = null
    }
}

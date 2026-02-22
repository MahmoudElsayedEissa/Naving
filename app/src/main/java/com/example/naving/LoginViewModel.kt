package com.example.naving

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _hasSignedUp = MutableLiveData(false)
    val hasSignedUp: LiveData<Boolean> get() = _hasSignedUp

    fun setEmail(email: String) {
        _email.value = email
    }

    fun markSignedUp() {
        _hasSignedUp.value = true
    }
}

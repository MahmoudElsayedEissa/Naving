package com.example.naving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels

class SignUpFragment : Fragment() {

    private val loginViewModel: LoginViewModel by navGraphViewModels(R.id.login_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_sign_up, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSignUpButton(view)
    }

    private fun setupSignUpButton(view: View) {
        view.findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            loginViewModel.setEmail("newuser@example.com")
            loginViewModel.markSignedUp()
            findNavController().navigate(R.id.action_signup_to_login)
        }
    }
}

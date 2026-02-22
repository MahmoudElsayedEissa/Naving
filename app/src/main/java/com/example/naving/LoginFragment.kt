package com.example.naving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by navGraphViewModels(R.id.login_graph)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeSignUpState()
        setupLoginButton(view)
        setupSignUpButton(view)
    }

    private fun observeSignUpState() {
        loginViewModel.hasSignedUp.observe(viewLifecycleOwner) { hasSignedUp ->
            if (hasSignedUp) {
                showToast("Welcome back from Sign Up! Email: ${loginViewModel.email.value}")
            }
        }
    }

    private fun setupLoginButton(view: View) {
        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {
            AuthState.isLoggedIn = true
            loginViewModel.setEmail("user@example.com")
            showToast("Logged in!")
            findNavController().navigate(R.id.action_login_to_home)
        }
    }

    private fun setupSignUpButton(view: View) {
        view.findViewById<Button>(R.id.btnGoToSignUp).setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signup)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}

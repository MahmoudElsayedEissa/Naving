package com.example.naving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class SettingsMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_settings_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (handleRouting()) return
        setupProfileButton(view)
    }

    private fun handleRouting(): Boolean {
        val target = arguments?.getString("targetDestination") ?: "main"
        val profileArgs = ProfileFragmentArgs(userId = 42, userName = "ViaRouter").toBundle()

        return when (target) {
            "profile" -> {
                arguments?.putString("targetDestination", "main")
                findNavController().navigate(
                    R.id.profileFragment,
                    profileArgs,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.settingsMainFragment, inclusive = true)
                        .build()
                )
                true
            }
            "profile_popup_home" -> {
                arguments?.putString("targetDestination", "main")
                findNavController().navigate(
                    R.id.profileFragment,
                    profileArgs,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.homeFragment, inclusive = false)
                        .build()
                )
                true
            }
            else -> false
        }
    }

    private fun setupProfileButton(view: View) {
        view.findViewById<Button>(R.id.btnGoToProfile).setOnClickListener {
            findNavController().navigate(
                SettingsMainFragmentDirections.actionSettingsToProfile(
                    userId = 1,
                    userName = "Mahmoud"
                )
            )
        }
    }
}

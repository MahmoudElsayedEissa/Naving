package com.example.naving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class SettingsMainFragment : Fragment() {

    private val navViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_settings_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSharedViewModelRouting()
        setupProfileButton(view)
    }


    private fun observeSharedViewModelRouting() {
        navViewModel.navigateTo.observe(viewLifecycleOwner) { destination ->
            if (destination != "profile") return@observe
            navViewModel.onNavigationHandled()
            findNavController().navigate(
                R.id.profileFragment,
                ProfileFragmentArgs(userId = 42, userName = "ViaViewModel").toBundle(),
                NavOptions.Builder()
                    .setPopUpTo(R.id.settingsMainFragment, inclusive = true)
                    .build()
            )
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

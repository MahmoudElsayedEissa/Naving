package com.example.naving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.net.toUri

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private val navViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayArgs(view)
        setupReturnResultButton(view)
        setupNavigationButtons(view)
    }

    private fun displayArgs(view: View) {
        view.findViewById<TextView>(R.id.tvArgs).text = buildString {
            appendLine("itemId = ${args.itemId}")
            appendLine("itemName = ${args.itemName}")
            appendLine("price = ${args.price}")
            appendLine("category = ${args.category}")
        }
    }

    private fun setupReturnResultButton(view: View) {
        view.findViewById<Button>(R.id.btnReturnResult).setOnClickListener {
            findNavController().previousBackStackEntry
                ?.savedStateHandle
                ?.set(HomeFragment.RESULT_KEY_SELECTED_ITEM, args.itemName)
            findNavController().popBackStack()
        }
    }

    private fun setupNavigationButtons(view: View) {
        view.findViewById<Button>(R.id.btnWay1).setOnClickListener { navigateDoubleNavGlobal() }
        view.findViewById<Button>(R.id.btnWay2).setOnClickListener { navigateDoubleNavGlobalPopUpToHome() }
        view.findViewById<Button>(R.id.btnWay3).setOnClickListener { navigateDeepLink() }
        view.findViewById<Button>(R.id.btnWay4).setOnClickListener { navigateDeepLinkPopUpToHome() }
        view.findViewById<Button>(R.id.btnWay5).setOnClickListener { navigateDoubleNav() }
        view.findViewById<Button>(R.id.btnWay6).setOnClickListener { navigateViaSharedViewModel() }
        view.findViewById<Button>(R.id.btnWay7).setOnClickListener { navigateDirectRootGraph() }
    }

    private fun navigateDoubleNavGlobal() {
        val profileArgs = ProfileFragmentArgs(userId = 42, userName = "ViaDoubleNavGlobal").toBundle()
        findNavController().navigate(R.id.action_global_to_profile)
        findNavController().navigate(R.id.action_settings_to_profile, profileArgs)
    }

    private fun navigateDoubleNavGlobalPopUpToHome() {
        val profileArgs = ProfileFragmentArgs(userId = 42, userName = "ViaDoubleNavGlobalPopUp").toBundle()
        findNavController().navigate(R.id.action_global_to_profile)
        findNavController().navigate(R.id.action_settings_to_profile_popup_home, profileArgs)
    }

    private fun navigateDeepLink() {
        findNavController().navigate(
            NavDeepLinkRequest.Builder
                .fromUri("naving://profile/42/ViaDeepLink".toUri())
                .build()
        )
    }

    private fun navigateDeepLinkPopUpToHome() {
        findNavController().navigate(
            NavDeepLinkRequest.Builder
                .fromUri("naving://profile/42/ViaDeepLinkPopUp".toUri())
                .build(),
            NavOptions.Builder()
                .setPopUpTo(R.id.homeFragment, inclusive = false)
                .build()
        )
    }

    private fun navigateDoubleNav() {
        val profileArgs = ProfileFragmentArgs(userId = 42, userName = "ViaDoubleNav").toBundle()
        findNavController().navigate(R.id.settings_graph)
        findNavController().navigate(
            R.id.profileFragment,
            profileArgs,
            NavOptions.Builder()
                .setPopUpTo(R.id.settingsMainFragment, inclusive = true)
                .build()
        )
    }

    private fun navigateViaSharedViewModel() {
        navViewModel.requestNavigation("profile")
        findNavController().navigate(R.id.settings_graph)
    }

    private fun navigateDirectRootGraph() {
        val profileArgs = ProfileFragmentArgs(userId = 42, userName = "ViaGlobalAction").toBundle()
        findNavController().navigate(R.id.action_global_to_profile_direct, profileArgs)
    }
}

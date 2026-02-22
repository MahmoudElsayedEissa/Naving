package com.example.naving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

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
        view.findViewById<Button>(R.id.btnWay1).setOnClickListener { navigateRouterHack() }
        view.findViewById<Button>(R.id.btnWay2).setOnClickListener { navigateRouterHackPopUpToHome() }
        view.findViewById<Button>(R.id.btnWay3).setOnClickListener { navigateDeepLink() }
        view.findViewById<Button>(R.id.btnWay4).setOnClickListener { navigateDeepLinkPopUpToHome() }
    }

    private fun navigateRouterHack() {
        findNavController().navigate(
            R.id.action_global_to_profile,
            bundleOf("targetDestination" to "profile")
        )
    }

    private fun navigateRouterHackPopUpToHome() {
        findNavController().navigate(
            R.id.action_global_to_profile,
            bundleOf("targetDestination" to "profile_popup_home")
        )
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
}

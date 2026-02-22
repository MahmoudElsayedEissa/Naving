package com.example.naving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class ProfileFragment : Fragment() {

    private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayProfileInfo(view)
    }

    private fun displayProfileInfo(view: View) {
        view.findViewById<TextView>(R.id.tvProfileArgs).text = buildString {
            appendLine("userId = ${args.userId}")
            appendLine("userName = ${args.userName}")
        }
    }
}

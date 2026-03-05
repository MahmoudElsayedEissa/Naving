package com.example.naving.navigation_example

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs

class ConfirmDialogFragment : DialogFragment() {

    private val args: ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Confirm")
            .setMessage(args.message)
            .setPositiveButton("OK", null)
            .setNegativeButton("Cancel", null)
            .create()
    }
}

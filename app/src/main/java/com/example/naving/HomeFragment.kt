package com.example.naving

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDetailResult(view)
        setupNavigationButtons(view)
    }

    private fun observeDetailResult(view: View) {
        val tvResult = view.findViewById<TextView>(R.id.tvResult)

        findNavController().currentBackStackEntry?.savedStateHandle
            ?.getLiveData<String>(RESULT_KEY_SELECTED_ITEM)
            ?.observe(viewLifecycleOwner) { result ->
                tvResult.text = "Result from Detail: $result"
            }
    }

    private fun setupNavigationButtons(view: View) {
        view.findViewById<Button>(R.id.btnGoToDetail).setOnClickListener {
            navigateToDetail()
        }

        view.findViewById<Button>(R.id.btnGoToLogin).setOnClickListener {
            findNavController().navigate(R.id.login_graph)
        }

        view.findViewById<Button>(R.id.btnGlobalLogin).setOnClickListener {
            findNavController().navigate(R.id.action_global_to_login)
        }

        view.findViewById<Button>(R.id.btnShowDialog).setOnClickListener {
            navigateToConfirmDialog()
        }

        view.findViewById<Button>(R.id.btnSendNotification).setOnClickListener {
            sendNotificationWithDeepLink()
        }

        view.findViewById<Button>(R.id.btnProtectedScreen).setOnClickListener {
            navigateToProtectedScreen()
        }
    }

    private fun navigateToDetail() {
        val action = HomeFragmentDirections.actionHomeToDetail(
            itemId = 42,
            itemName = "Laptop",
            price = 999.99f,
            category = ProductCategory.ELECTRONICS
        )
        findNavController().navigate(action)
    }

    private fun navigateToConfirmDialog() {
        val action = HomeFragmentDirections.actionHomeToConfirm(
            message = "Are you sure you want to proceed?"
        )
        findNavController().navigate(action)
    }

    private fun navigateToProtectedScreen() {
        if (AuthState.isLoggedIn) {
            val action = HomeFragmentDirections.actionHomeToDetail(
                itemId = 99,
                itemName = "Protected Item",
                price = 0f,
                category = ProductCategory.BOOKS
            )
            findNavController().navigate(action)
        } else {
            showToast("Not logged in! Redirecting to Login...")
            findNavController().navigate(R.id.action_global_to_login)
        }
    }

    private fun sendNotificationWithDeepLink() {
        val context = requireContext()
        val channelId = "nav_deep_link_channel"

        createNotificationChannel(channelId)

        val pendingIntent = NavDeepLinkBuilder(context)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.profileFragment)
            .setArguments(ProfileFragmentArgs(userId = 7, userName = "DeepLinkUser").toBundle())
            .setComponentName(MainActivity::class.java)
            .createPendingIntent()

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Navigation Example")
            .setContentText("Tap to deep link to Profile screen")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        context.getSystemService(NotificationManager::class.java).notify(NOTIFICATION_ID, notification)
        showToast("Notification sent! Check notification tray.")
    }

    private fun createNotificationChannel(channelId: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Deep Link Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            requireContext().getSystemService(NotificationManager::class.java)
                .createNotificationChannel(channel)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val RESULT_KEY_SELECTED_ITEM = "selected_item"
        private const val NOTIFICATION_ID = 1
    }
}

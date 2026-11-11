
package com.yazdan.vpn

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.*
import android.graphics.Typeface

class MainActivity : Activity() {

    private lateinit var status: TextView
    private lateinit var connectButton: Button
    private lateinit var serverInput: EditText
    private var connected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(24, 35, 24, 25)
            setBackgroundColor(Color.rgb(10, 18, 35))
        }

        val title = TextView(this).apply {
            text = "YAZDAN VPN"
            textSize = 30f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Secure Internet Connection"
            textSize = 14f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
        }

        status = TextView(this).apply {
            text = "DISCONNECTED"
            textSize = 20f
            setTextColor(Color.RED)
            gravity = Gravity.CENTER
            setPadding(0, 45, 0, 30)
        }

        serverInput = EditText(this).apply {
            hint = "Server address (host:port)"
            setSingleLine(true)
            setTextColor(Color.WHITE)
            setHintTextColor(Color.LTGRAY)
            setPadding(15, 15, 15, 15)
        }

        connectButton = Button(this).apply {
            text = "CONNECT"
            textSize = 18f
            setOnClickListener {
                connected = !connected
                updateStatus()
            }
        }

        val configButton = Button(this).apply {
            text = "IMPORT CONFIG"
            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Config import will be added soon",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        val footer = TextView(this).apply {
            text = "SSH  |  SSL  |  HTTP TUNNEL\nYazdan VPN v1.0"
            gravity = Gravity.CENTER
            textSize = 13f
            setTextColor(Color.LTGRAY)
            setPadding(0, 40, 0, 0)
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(status)
        layout.addView(serverInput)
        layout.addView(connectButton)
        layout.addView(configButton)
        layout.addView(footer)

        setContentView(layout)
    }

    private fun updateStatus() {
        if (connected) {
            status.text = "DEMO MODE - NOT CONNECTED"
            status.setTextColor(Color.YELLOW)
            connectButton.text = "DISCONNECT"
            connected = false
        } else {
            status.text = "DISCONNECTED"
            status.setTextColor(Color.RED)
            connectButton.text = "CONNECT"
        }
    }
}
